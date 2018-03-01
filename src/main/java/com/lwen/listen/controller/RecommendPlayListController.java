package com.lwen.listen.controller;

import com.lwen.listen.entity.PlayList;
import com.lwen.listen.service.RecommendPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

@Component
@RestController
public class RecommendPlayListController {
    @Autowired
    RecommendPlayListService playListService;


    @GetMapping("/recommendPlayList")
    public List<PlayList> getRecommendPlayList() {
        return playListService.getRecommendPlayList();
    }


    @GetMapping(value = "/recommendPlayLists/offset/{offset}/limit/{limit}/type/{type}")
    public List<PlayList> getRecommendPlayLists(@PathVariable("offset")Long offset,
                                                @PathVariable("limit")Long limit,
                                                @PathVariable("type")String type
                                                ) throws UnsupportedEncodingException {
        // System.out.println(type);
        RecommendPlayListService playListService = new RecommendPlayListService(offset,limit,type);
        return playListService.getRecommendPlayList();
    }
}
