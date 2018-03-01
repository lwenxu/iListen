package com.lwen.listen.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;
public class TagListServiceTest {
    TagListService tagListService = new TagListService();
    @Test
    public void getTagListJson() throws Exception {
        System.out.println(tagListService.getTagListJson());
    }


}
