package com.lwen.listen.controller;

import com.lwen.listen.entity.PlayList;
import com.lwen.listen.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class PlayListController {
    @Autowired
    PlayListService playListService;

    @GetMapping("/getPlayListDetailById/id/{id}")
    public PlayList getPlayListDetailById(@PathVariable String id) {
        return playListService.getPlayListDetailByPlayListId(id);
    }

    @GetMapping("/getTopPlayLists")
    public String getTopPlayLists() {
        return playListService.getTopPlayLists();
    }

    @GetMapping("/getLikedListById/id/{id}")
    public String getLikedList(@PathVariable String id) {
        return playListService.getLikedList(id);
    }

    @GetMapping("/getUserPlayListById/id/{id}/offset/{offset}/limit/{limit}")
    public String getUserPlayListById(@PathVariable String id,
                                      @PathVariable String offset,
                                      @PathVariable String limit) {
        return playListService.getUserPlayListById( id, offset, limit);
    }
}
