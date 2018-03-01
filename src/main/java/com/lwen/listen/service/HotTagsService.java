package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Tag;
import com.lwen.listen.spider.Spider;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotTagsService extends HomeService{

    public Document getHotTagsJson(){
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/playlist/hottags";
        Spider spider = new Spider(headers, url, data, cookie);
        return spider.getRequest();
    }

    public List<Tag> jsonToBeans() {
        List<Tag> result = new ArrayList<>();
        Document document = getHotTagsJson();
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(document.body().html(), JsonObject.class);
        System.out.println(object);
        JsonElement element = object.get("tags");
        for (JsonElement ele : element.getAsJsonArray()) {
            JsonObject obj = ele.getAsJsonObject();
            Tag tag = new Tag(
                    obj.get("hot").getAsBoolean(),
                    obj.get("usedCount").getAsLong(),
                    obj.get("createTime").getAsLong(),
                    obj.get("position").getAsInt(),
                    obj.get("category").getAsInt(),
                    obj.get("name").getAsString(),
                    obj.get("id").getAsInt(),
                    obj.get("type").getAsInt()
            );
            result.add(tag);
        }
        return result;
    }
}
