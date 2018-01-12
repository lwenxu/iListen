package com.lwen.listen.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.lwen.listen.entity.Tag;

import java.util.HashSet;
import java.util.Set;

public class TagService extends HomeService{
    public Set<Tag> JsonToBean(JsonElement tags) {
        Set<Tag> result = new HashSet<>();
        JsonArray jsonArray = tags.getAsJsonArray();
        for (JsonElement item : jsonArray) {
            //TODO::获取所有的歌曲类型  编号存放入数据库  用于查表
            Integer id = 1;
            String typeName = item.getAsString();

            Tag tag = new Tag(id, typeName);
            result.add(tag);
        }
        return result;
    }
}
