package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Music;
import com.lwen.listen.entity.PlayList;
import com.lwen.listen.spider.Spider;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayListService extends HomeService{
    RecommendService recommendService = new RecommendService();
    private Spider spider;

    public PlayListService(Long id) {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/playlist/detail";
        data.put("id", id + "");
        spider = new Spider(headers, url, data, cookie);
    }

    public PlayList getPlayListDetailByPlayListId(){
        String document = spider.getRequest().body().html();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(document, JsonObject.class);
        JsonElement jsonElement = jsonObject.get("result");

        PlayList playList = recommendService.JsonToBean(jsonElement);
        MusicService musicService = new MusicService();
        Set<Music> music = musicService.JsonToBeanList(jsonElement.getAsJsonObject().get("tracks").getAsJsonArray());
        playList.setMusics(music);

        System.out.println(playList);
        return new PlayList();
    }

}
