package com.lwen.listen.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.User;
import lombok.NonNull;

public class UserService extends HomeService {
    public @NonNull User JsonToBean(JsonElement creator) {
        JsonObject jsonObject = creator.getAsJsonObject();

        //User Attributes
        Long userId = jsonObject.get("userId").getAsLong();
        Long province = jsonObject.get("province").getAsLong();      //440000 身份证前几位
        String avatarUrl = jsonObject.get("avatarUrl").toString().replaceAll("\"", "");
        Integer gender = jsonObject.get("gender").getAsInt();
        Long city = jsonObject.get("city").getAsLong();      // 440900
        String birthday = jsonObject.get("birthday").toString().replaceAll("\"", "");    //722880000000,
        Integer userType = jsonObject.get("userType").getAsInt();
        String nickname = jsonObject.get("nickname").toString().replaceAll("\"", "");
        String signature = jsonObject.get("signature").toString().replaceAll("\"", "");
        String description = jsonObject.get("description").toString().replaceAll("\"", "");
        String detailDescription = jsonObject.get("detailDescription").toString().replaceAll("\"", "");
        String backgroundUrl = jsonObject.get("backgroundUrl").toString().replaceAll("\"", "");

        User user = new User(userId, province, avatarUrl, gender, city, birthday, userType, nickname, signature, description, detailDescription, backgroundUrl);
        return user;
    }
}
