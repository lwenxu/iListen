package com.lwen.listen.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Artist;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ArtistService extends HomeService {
    public List<Artist> JsonToBeanList(JsonArray artists) {
        List<Artist> result = new ArrayList<>();
        for (JsonElement element : artists) {
            result.add(JsonToBean(element.getAsJsonObject()));
        }
        return result;
    }

    public @NonNull Artist JsonToBean(JsonObject artist) {

        String name = artist.get("name").getAsString();
        Long id = artist.get("id").getAsLong();
        String picUrl = artist.get("picUrl").getAsString();

        Artist result = new Artist(id, name, picUrl);
        return result;
    }

}
