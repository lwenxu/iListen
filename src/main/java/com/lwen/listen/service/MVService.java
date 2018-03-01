package com.lwen.listen.service;

import com.google.gson.JsonObject;
import com.lwen.listen.entity.Artist;
import com.lwen.listen.entity.MV;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MVService {
    public MV jsonToBean(JsonObject jsonObject) {
        ArtistService artist = new ArtistService();
        MV mv = new MV(
                jsonObject.get("id").getAsInt(),
                jsonObject.get("type").getAsInt(),
                jsonObject.get("name").getAsString(),
                jsonObject.get("copywriter").getAsString(),
                jsonObject.get("picUrl").getAsString(),
                jsonObject.get("canDislike").getAsBoolean(),
                jsonObject.get("duration").getAsLong(),
                jsonObject.get("playCount").getAsInt(),
                jsonObject.get("subed").getAsBoolean(),
                artist.JsonToBeanList(jsonObject.get("artists").getAsJsonArray()),
                jsonObject.get("artistName").getAsString(),
                jsonObject.get("artistId").getAsInt(),
                jsonObject.get("alg").getAsString()
        );
        return mv;
    }
}
