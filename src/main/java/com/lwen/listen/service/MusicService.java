package com.lwen.listen.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Album;
import com.lwen.listen.entity.Artist;
import com.lwen.listen.entity.Music;
import com.lwen.listen.spider.Spider;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MusicService extends HomeService{

    private ArtistService artistService = new ArtistService();


    public Set<Music> JsonToBeanList(JsonArray asJsonArray) {
        Set<Music> result = new HashSet<>();
        for (JsonElement item : asJsonArray) {
            result.add(JsonToBean(item.getAsJsonObject()));
        }
        return result;
    }

    public Music JsonToBean(@NonNull JsonObject jsonObject) {
        AlbumService albumService = new AlbumService();

        String name=jsonObject.get("name").getAsString();
        Long id=jsonObject.get("id").getAsLong();
        String alias = jsonObject.get("alias").getAsJsonArray().size() != 0 ? jsonObject.get("alias").getAsJsonArray().get(0).getAsString() : "";
        String copyrightId = jsonObject.get("copyrightId").getAsString();
        Set<Artist> artists=artistService.JsonToBeanList(jsonObject.get("artists").getAsJsonArray());
        Album album = albumService.JsonToBean(jsonObject.get("album").getAsJsonObject());
        Boolean starred = jsonObject.get("starred").getAsBoolean();
        String crbt = jsonObject.get("crbt").isJsonNull()?"":jsonObject.get("crbt").getAsString();
        String commentId=jsonObject.get("commentThreadId").getAsString();
        Long mvid=jsonObject.get("mvid").getAsLong();
        String mp3Url = jsonObject.get("mp3Url").isJsonNull()?"":jsonObject.get("mp3Url").getAsString();
        Long highId = jsonObject.get("hMusic").isJsonNull()?0:jsonObject.get("hMusic").getAsJsonObject().get("id").getAsLong();
        Long mediumId = jsonObject.get("mMusic").isJsonNull()?0:jsonObject.get("mMusic").getAsJsonObject().get("id").getAsLong();
        Long lowId = jsonObject.get("lMusic").isJsonNull()?0:jsonObject.get("lMusic").getAsJsonObject().get("id").getAsLong();

        Music music = new Music(id, name, alias, copyrightId, artists, album, starred, crbt, commentId, mvid, mp3Url, highId, mediumId, lowId);

        return music;
    }

    public String getMusicDetailById(String id) {
        String data = "{\"id\":"+id+",\"c\":\"[{\\\"id\\\":"+id+"}]\",\"ids\":\"["+id+"]\",\"csrf_token\":\"\"}";
        return Spider.postRequest("http://music.163.com/weapi/v3/song/detail",data);
    }


    public String getMusicUrlById(String id) {
        String data = "{\"ids\":["+id+"],\"br\":\"128000\",\"csrf_token\":\"\"}";
        return Spider.postRequest("http://music.163.com/weapi/song/enhance/player/url", data);
    }

    public String getCommentsById(String id, String limit, String offset, String type) {
        String data = "{\"rid\":\"" + id + "\",\"offset\":\"" + offset + "\",\"limit\":\"" + limit + "\",\"total\":false,\"csrf_token\":\"\"}";
        System.out.println(data);
        type = type.equals("hot") ? "hotcomments" : "comments";
        return Spider.postRequest("http://music.163.com/weapi/v1/resource/" + type + "/" + id, data);
    }

    public String getLyricById(String id) {
        return Spider.getRequest("http://music.163.com/api/song/lyric", "os=osx&id=" + id + "&lv=-1&kv=-1&tv=-1");
    }

    public String searchByMusicName(String name, String limit, String type, String offset) {
        // String data = "{\"s\":\"" + name + "\",\"offset\":\"" + offset + "\",\"limit\":\"" + limit + "\",\"type\":\"" + type + "\"}";
        Map<String, String> data = new HashMap<>();
        Map<String, String> header = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        data.put("s", name);
        data.put("limit", limit);
        data.put("type", type);
        data.put("offset", offset);
        String url = "http://music.163.com/api/search/get/";
        header.put("Cookie", "appver=2.0.2");
        return Spider.postRequest(url, header, data, cookie);
    }
}
