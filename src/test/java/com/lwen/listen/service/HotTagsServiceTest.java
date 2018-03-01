package com.lwen.listen.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class HotTagsServiceTest {
    HotTagsService hotTagsService = new HotTagsService();
    @Test
    public void jsonToBeans() throws Exception {
        hotTagsService.jsonToBeans();
    }

}
