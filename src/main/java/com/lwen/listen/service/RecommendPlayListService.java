package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.PlayList;
import com.lwen.listen.entity.Tag;
import com.lwen.listen.entity.User;
import com.lwen.listen.spider.Spider;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RecommendPlayListService extends HomeService {
    private Spider spider;

    public RecommendPlayListService() {
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


    public RecommendPlayListService(Long offset,Long limit,String type) {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/playlist/list";
        data.put("cat", type);
        data.put("order", "1");
        data.put("offset", offset+"");
        data.put("total", "true");
        data.put("limit", limit + "");
        spider = new Spider(headers, url, data, cookie);
    }

    public List<PlayList> getRecommendPlayList() {
        String document = spider.getRequest().body().html();
        System.out.println(document);
        List<PlayList> result = new ArrayList<>();
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(document, JsonObject.class);
        JsonArray jsonArray = jsonObject.get("playlists").getAsJsonArray();
        for (JsonElement aJsonArray : jsonArray) {
            result.add(JsonToBean(aJsonArray));
        }
        return result;
    }

    public PlayList JsonToBean(JsonElement aJsonArray) {
            JsonObject item = aJsonArray.getAsJsonObject();
            // Attributes Java bean need
            String name = item.get("name").toString().replaceAll("\"", "");
            Long id = Long.parseLong(item.get("id").toString().replaceAll("\"", ""));
            String updateTime = item.get("updateTime").toString().replaceAll("\"", "");
            String createTime = item.get("createTime").toString().replaceAll("\"", "");
            Long uid = Long.parseLong(item.get("userId").toString().replaceAll("\"", ""));
            Long subscribedCount = Long.parseLong(item.get("subscribedCount").toString().replaceAll("\"", ""));
            Long trackCount = Long.parseLong(item.get("trackCount").toString().replaceAll("\"", ""));
            String coverImgUrl = item.get("coverImgUrl").toString().replaceAll("\"", "");
            String description = item.get("description").toString().replaceAll("\"", "");
            Long playCount = Long.parseLong(item.get("playCount").toString().replaceAll("\"", ""));
            String commentId = item.get("commentThreadId").toString().replaceAll("\"", "");
            Long shareCount = Long.parseLong(item.get("shareCount").toString().replaceAll("\"", ""));
            Long commentCount = Long.parseLong(item.get("commentCount").toString().replaceAll("\"", ""));
            User createUser = new UserService().JsonToBean(item.get("creator"));
            Set<Tag> tags = new TagService().JsonToBean(item.get("tags"));
            String coverImgId_str = item.get("coverImgId_str")==null?"": item.get("coverImgId_str").getAsString();
            PlayList playList = new PlayList(id, name, updateTime,coverImgId_str ,createTime, uid, subscribedCount, trackCount, coverImgUrl, description, playCount, commentId, shareCount, commentCount, createUser, tags, null);
            return playList;
    }
}
