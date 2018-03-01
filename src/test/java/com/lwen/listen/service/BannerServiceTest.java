package com.lwen.listen.service;


import org.junit.Test;

public class BannerServiceTest {
    BannerService bannerService = new BannerService();
    @Test
    public void jsonToBean() {
        System.out.println(bannerService.JsonToBean());;
    }

}