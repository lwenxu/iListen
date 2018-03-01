package com.lwen.listen.controller;

import com.lwen.listen.entity.MV;
import com.lwen.listen.service.MVService;
import com.lwen.listen.service.RecommendMVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
@RestController
public class MVController {
    @Autowired
    RecommendMVService recommendMVService;

    @GetMapping("/recommendMV")
    public List<MV> recommendMV() {
        return recommendMVService.getRecommendMV();
    }

}
