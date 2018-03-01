package com.lwen.listen.service;

import org.junit.Test;

public class RecommendMVServiceTest {

    RecommendMVService service = new RecommendMVService();

    @Test
    public void getRecommendMV() throws Exception {
        System.out.println(service.getRecommendMV().size());
    }

    @Test
    public void jsonToBean() throws Exception {
    }


}
