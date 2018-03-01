package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Music;
import com.lwen.listen.spider.Spider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecommendDayMusicService extends HomeService {
    private MusicService music = new MusicService();

    public List<Music> getRecommendDayMusic() throws Exception {
        String data = "{\"offset\":0,\"limit\":20,\"total\":\"True\",\"csrf_token\":\"\"}";
        String document = Spider.postRequest("http://music.163.com/weapi/v1/discovery/recommend/resource",data);
        System.out.println(document);
        List<Music> result = new ArrayList<>();
        // Gson gson = new Gson();
        // JsonObject jsonObject = gson.fromJson(document, JsonObject.class);
        // JsonArray jsonArray = jsonObject.get("result").getAsJsonArray();
        // for (JsonElement aJsonArray : jsonArray) {
        //     // System.out.println(aJsonArray.getAsJsonObject().get("song").getAsJsonObject());
        //     result.add(JsonToBean(aJsonArray.getAsJsonObject().get("song").getAsJsonObject()));
        // }
        return result;
    }

    public Music JsonToBean(JsonElement aJsonArray) {
        JsonObject item = aJsonArray.getAsJsonObject();
        return music.JsonToBean(item);
    }
}
