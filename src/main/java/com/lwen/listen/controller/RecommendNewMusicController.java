package com.lwen.listen.controller;

import com.lwen.listen.entity.Music;
import com.lwen.listen.service.RecommendMusicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class RecommendNewMusicController {
    @Autowired
    RecommendMusicsService musicsService;

    @GetMapping("/getRecommendMusics")
    public List<Music> getRecommendMusics() {
        return musicsService.getRecommendPlayList();
    }
}
