package com.vmware.talentboost.springbootfinaltask.service.Impl;

import com.vmware.talentboost.springbootfinaltask.data.Tags;
import com.vmware.talentboost.springbootfinaltask.repository.TagsRepository;
import com.vmware.talentboost.springbootfinaltask.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    private final TagsRepository tagRepo;

    public TagsRepository getTagRepo() {
        return tagRepo;
    }

    public TagServiceImpl(TagsRepository tagRepo){
        this.tagRepo = tagRepo;
    }

    @Override
    public void saveTag(Tags tag) {
        tagRepo.save(tag);
    }

    /*@Override
    public List<Tags> getAll(){
        return tagRepo.findAll();
    }
    @Override
    public Tags get(String name) {
        Tags tag = tagRepo.findOneByName(name);
        return tag;
    }*/
}
