package com.lwen.listen.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Album;
import com.lwen.listen.entity.Artist;
import com.lwen.listen.entity.Music;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class MusicService extends HomeService{

    private ArtistService artistService = new ArtistService();


    public List<Music> JsonToBeanList(JsonArray asJsonArray) {
        List<Music> result = new ArrayList<>();
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
        List<Artist> artists=artistService.JsonToBeanList(jsonObject.get("artists").getAsJsonArray());
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
}
