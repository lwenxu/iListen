package com.lwen.listen.controller;

import com.lwen.listen.service.TagListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class TagListController {
    @Autowired
    TagListService tagListService;

    @GetMapping("/getTagLists")
    public String getTagLists() throws Exception {
        return tagListService.getTagListJson();
    }
}
