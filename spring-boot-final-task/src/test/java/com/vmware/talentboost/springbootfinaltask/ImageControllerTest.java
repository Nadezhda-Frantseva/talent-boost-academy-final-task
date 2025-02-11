package com.vmware.talentboost.springbootfinaltask;

import static org.assertj.core.api.Assertions.assertThat;

import com.vmware.talentboost.springbootfinaltask.controller.ImageController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ImageControllerTest {

    @Autowired
    private ImageController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}