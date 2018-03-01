package com.lwen.listen.controller;

import com.lwen.listen.entity.PlayList;
import com.lwen.listen.service.PlayListService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class NetHotMusicController {
    PlayListService playListService = new PlayListService();

    @GetMapping("/getNeteaseHotMusic")
    public PlayList getNeteaseHotMusic() {

        return playListService.getPlayListDetailByPlayListId("3778678");
    }
}
