package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.PlayList;
import com.lwen.listen.spider.Spider;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

public class RecommendService extends HomeService{
    private Spider spider;

    public RecommendService(){
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/playlist/list?";
        data.put("cat", "全部");
        data.put("order", "1");
        data.put("offset", "1");
        data.put("total", "true");
        data.put("limit", "10");
        spider = new Spider(headers, url, data, cookie);
    }

    public PlayList getRecommendPlayList(){
        Document document = spider.getRequest();
        System.out.println(document.body().html());
        Gson gson = new Gson();
        JsonObject jsonObject= gson.fromJson(document.body().html().toString(), JsonObject.class);
        PlayList playList= gson.fromJson(document.body().html().toString(), PlayList.class);
        System.out.println(jsonObject.get("playlists").getAsJsonArray().get(0));
//        jsonObject.get()

        return new PlayList();
    }
}
