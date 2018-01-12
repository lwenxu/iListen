package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Album;
import com.lwen.listen.entity.Artist;
import com.lwen.listen.entity.Music;
import com.lwen.listen.spider.Spider;
import lombok.NonNull;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumService extends HomeService {
    private ArtistService artistService = new ArtistService();
    private MusicService musicService = new MusicService();

    public Album JsonToBean(JsonObject album) {
        Long id = album.get("id").getAsLong();
        String name = album.get("name").getAsString();
        Integer size = album.get("size").getAsInt();
        String blurPicUrl = album.get("blurPicUrl").getAsString();
        String picUrl = album.get("picUrl").getAsString();
        String publishTime = album.get("publishTime").getAsString();
        String description = album.get("description").getAsString();
        String tags = album.get("tags").getAsString();
        String company = album.get("company").getAsString();
        String briefDesc = album.get("briefDesc").getAsString();
        Artist artist = artistService.JsonToBean(album.get("artist").getAsJsonObject());
        String commentId = album.get("commentThreadId").getAsString();

        Album result = new Album(id, name, size, blurPicUrl, picUrl, publishTime, description, tags, company, briefDesc, artist, commentId);
        return result;
    }

    public @NonNull Document getMusicJsonByAlbumId(Long albumId){
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/album/"+albumId;
        headers.put("Referer", "http://music.163.com");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        cookie.put("appver", "2.0.2");
        Spider spider = new Spider(headers, url, data, cookie);
        Document document = spider.getRequest();
        return document;
    }

    public List<Music> getMusicListByAlbumId(Long albumId){
        Gson gson = new Gson();
        @NonNull JsonObject jsonObject = gson.fromJson(getMusicJsonByAlbumId(albumId).body().html(), JsonObject.class);
        return musicService.JsonToBeanList(jsonObject.get("album").getAsJsonObject().get("songs").getAsJsonArray());
    }
}
