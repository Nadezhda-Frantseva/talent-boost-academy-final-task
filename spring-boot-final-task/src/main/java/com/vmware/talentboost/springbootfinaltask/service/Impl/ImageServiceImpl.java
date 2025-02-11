package com.vmware.talentboost.springbootfinaltask.service.Impl;

import com.vmware.talentboost.springbootfinaltask.client.ImaggaClient;
import com.vmware.talentboost.springbootfinaltask.data.Image;
import com.vmware.talentboost.springbootfinaltask.data.Tags;
import com.vmware.talentboost.springbootfinaltask.data.TypeService;
import com.vmware.talentboost.springbootfinaltask.dto.DtoForTags.ImaggaTagDto;
import com.vmware.talentboost.springbootfinaltask.dto.DtoForTags.ImaggaTagsResponseDto;
import com.vmware.talentboost.springbootfinaltask.repository.ImageRepository;
import com.vmware.talentboost.springbootfinaltask.service.ImageService;
import com.vmware.talentboost.springbootfinaltask.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepo;
    private final TagService tagService;

    public ImageRepository getImageRepo() {
        return imageRepo;
    }

    public ImageServiceImpl(ImageRepository imageRepo, TagService tagService){
        this.imageRepo = imageRepo;
        this.tagService = tagService;
    }

    @Override
    public Image get(int id) {
        Optional<Image> img = imageRepo.findById(id);
        if (img.isPresent()) {
            return img.get();
        }
        throw new NoSuchElementException("Project with ID: " + id + " was not found!");
    }

    @Override
    public boolean IsInDB(String url) {
        Image img = imageRepo.findOneByUrl(url);
        if (img == null) {
            return false;
        }
        return true;
    }
    @Override
    public List<Image> getAll(){
        return imageRepo.findAll();
    }

    @Override
    public void save(Image image) {
        imageRepo.save(image);
    }

    @Transactional
    @Override
    public Image classifyImage(String url) throws URISyntaxException, IOException {
        ImaggaClient client = new ImaggaClient();
        ImaggaTagsResponseDto dto = client.returnImage(url);
        List<Tags> labels = new ArrayList<>();
        for (ImaggaTagDto tag : dto.getResult().getTags()) {
            Tags addLabel = new Tags(tag.getTag().getEn(), tag.getConfidence());
            labels.add(addLabel);
            tagService.saveTag(addLabel);
        }
        URL setUrl = new URL(url);
        final BufferedImage details = ImageIO.read(setUrl);
        Image imageForDB = new Image(url, TypeService.Imagga, details.getWidth(), details.getHeight(), labels);
        if (!IsInDB(url)) {
            save(imageForDB);
        }
        return imageForDB;
    }
}