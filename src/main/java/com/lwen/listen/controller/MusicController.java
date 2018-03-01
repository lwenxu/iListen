package com.lwen.listen.controller;

import com.lwen.listen.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class MusicController {
    @Autowired
    MusicService musicService;

    @GetMapping("getMusicDetailById/id/{id}")
    public String getMusicDetailById(@PathVariable String id) {
        return musicService.getMusicDetailById(id);
    }

    @GetMapping("getMusicUrlById/id/{id}")
    public String getMusicUrlById(@PathVariable String id) {
        return musicService.getMusicUrlById(id);
    }

    @GetMapping("getCommentsById/id/{id}/limit/{limit}/offset/{offset}/type/{type}")
    public String getCommentsById(@PathVariable String id,
                                  @PathVariable String limit,
                                  @PathVariable String offset,
                                  @PathVariable String type) {
        return musicService.getCommentsById(id, limit, offset, type);
    }

    @GetMapping("getLyricById/id/{id}")
    public String getLyricById(@PathVariable String id) {
        return musicService.getLyricById(id);
    }

}
