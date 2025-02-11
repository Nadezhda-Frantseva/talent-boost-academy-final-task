package com.vmware.talentboost.springbootfinaltask.service;

import com.vmware.talentboost.springbootfinaltask.data.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.List;

public interface ImageService {
    Image get(int id);
    boolean IsInDB(String url) throws UnknownHostException;
    List<Image> getAll();
    void save(Image image);
    Image classifyImage(String url) throws URISyntaxException, IOException;
}
