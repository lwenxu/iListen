package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Artist;
import com.lwen.listen.spider.Spider;
import lombok.NonNull;
import org.jsoup.nodes.Document;

import java.util.*;

public class ArtistService extends HomeService {
    public Set<Artist> JsonToBeanList(JsonArray artists) {
        Set<Artist> result = new HashSet<>();
        for (JsonElement element : artists) {
            result.add(JsonToBean(element.getAsJsonObject()));
        }
        return result;
    }

    public @NonNull
    Artist JsonToBean(JsonObject artist) {
        String name = artist.get("name").getAsString();
        Long id = artist.get("id").getAsLong();
        String picUrl = artist.get("picUrl").getAsString();

        Artist result = new Artist(id, name, picUrl);
        return result;
    }

    public @NonNull
    Document getArtistJsonId(Long artistId) {
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/artist/" + artistId;
        headers.put("Referer", "http://music.163.com");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        cookie.put("appver", "2.0.2");
        Spider spider = new Spider(headers, url, data, cookie);
        Document document = spider.getRequest();
        return document;
    }

    public Artist getArtistById(Long artistId) {
        Gson gson = new Gson();
        @NonNull JsonObject jsonObject = gson.fromJson(getArtistJsonId(artistId).body().html(), JsonObject.class);
        return JsonToBean(jsonObject.get("artist").getAsJsonObject());
    }

}
