package com.lwen.listen.controller;

import com.lwen.listen.entity.Banner;
import com.lwen.listen.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
public class BannerController {
    @Autowired
    BannerService bannerService;


    @GetMapping("/getBanner")
    public List<Banner> getBanner() {
        return bannerService.JsonToBean();
    }
}
