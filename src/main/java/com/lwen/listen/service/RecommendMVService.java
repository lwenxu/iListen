package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.MV;
import com.lwen.listen.entity.Music;
import com.lwen.listen.spider.Spider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RecommendMVService extends HomeService {
    private Spider spider;
    // @Autowired
    private MVService music = new MVService();

    public RecommendMVService() {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/personalized/mv";
        spider = new Spider(headers, url, data, cookie);
    }

    public List<MV> getRecommendMV() {
        String document = spider.getRequest().body().html();
        List<MV> result = new ArrayList<>();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(document, JsonObject.class);
        JsonArray jsonArray = jsonObject.get("result").getAsJsonArray();
        for (JsonElement aJsonArray : jsonArray) {
            result.add(music.jsonToBean(aJsonArray.getAsJsonObject()));
        }
        return result;
    }
}
