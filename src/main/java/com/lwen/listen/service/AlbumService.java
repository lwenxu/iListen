package com.lwen.listen.service;

import com.google.gson.JsonObject;
import com.lwen.listen.entity.Album;
import com.lwen.listen.entity.Artist;

public class AlbumService extends HomeService {
    private ArtistService artistService = new ArtistService();

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
}
