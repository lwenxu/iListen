package com.lwen.listen.service;


import org.junit.Test;
import org.springframework.stereotype.Component;

@Component
public class RecommendMusicsServiceTest {
    // @Autowired
    RecommendMusicsService service = new RecommendMusicsService();
    @Test
    public void getRecommendPlayList() {
        System.out.println(service.getRecommendPlayList());
    }

    @Test
    public void jsonToBean() {
    }

}