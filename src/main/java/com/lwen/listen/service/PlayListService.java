package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Music;
import com.lwen.listen.entity.PlayList;
import com.lwen.listen.spider.Spider;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PlayListService extends HomeService{
    RecommendPlayListService recommendPlayListService = new RecommendPlayListService();

    public PlayListService() {
    }

    public PlayList getPlayListDetailByPlayListId(String id){
        String document = Spider.getRequest("http://music.163.com/api/playlist/detail","id="+id);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(document, JsonObject.class);
        JsonElement jsonElement = jsonObject.get("result");

        PlayList playList = recommendPlayListService.JsonToBean(jsonElement);
        MusicService musicService = new MusicService();
        Set<Music> music = musicService.JsonToBeanList(jsonElement.getAsJsonObject().get("tracks").getAsJsonArray());
        playList.setMusics(music);
        return playList;
    }

    public String getTopPlayLists() {
        String document = Spider.postRequest("http://music.163.com/weapi/toplist/detail","{\"limit\":20,\"csrf_token\":\"\"}");
        return document;
    }

    public String getLikedList(String uid) {
        String data = "{\"uid\":\"" + uid + "\",\"csrf_token\":\"\"}";
        return Spider.postRequest("http://music.163.com/weapi/song/like/get", data);
    }

    public String getUserPlayListById(String id,String offset,String limit) {
        String data = "{\"offset\":\"" + offset + "\",\"uid\":\"" + id + "\",\"limit\":\"" + limit + "\",\"csrf_token\":\"\"}";
        return Spider.postRequest("http://music.163.com/weapi/user/playlist", data);
    }
}
