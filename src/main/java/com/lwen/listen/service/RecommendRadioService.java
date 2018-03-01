package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Music;
import com.lwen.listen.spider.Spider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RecommendRadioService extends HomeService {
    private Spider spider;
    // @Autowired
    private MusicService music = new MusicService();

    public RecommendRadioService() {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/personalized/djprogram";
        spider = new Spider(headers, url, data, cookie);
    }

    public List<Music> getRecommendPlayList() {
        String document = spider.getRequest().body().html();
        List<Music> result = new ArrayList<>();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(document, JsonObject.class);
        JsonArray jsonArray = jsonObject.get("result").getAsJsonArray();
        for (JsonElement aJsonArray : jsonArray) {
            // System.out.println(aJsonArray.getAsJsonObject().get("song").getAsJsonObject());
            result.add(JsonToBean(aJsonArray.getAsJsonObject().get("song").getAsJsonObject()));
        }
        return result;
    }

    public Music JsonToBean(JsonElement aJsonArray) {
        JsonObject item = aJsonArray.getAsJsonObject();
        return music.JsonToBean(item);
    }
}
