package com.lwen.listen.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lwen.listen.entity.Banner;
import com.lwen.listen.spider.Spider;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BannerService extends HomeService{

    public Document getTodayBannerJson(){
        Map<String, String> headers = new HashMap<>();
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        String url = "http://music.163.com/api/v2/banner/get";
        Spider spider = new Spider(headers, url, data, cookie);
        return spider.getRequest();
    }

    public List<Banner> JsonToBean(){
        List<Banner> result = new ArrayList<>();
        Document document = getTodayBannerJson();
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(document.body().html(), JsonObject.class);
        JsonElement element = object.get("banners");
        for (JsonElement ele : element.getAsJsonArray()) {
            JsonObject obj = ele.getAsJsonObject();
            Banner banner = new Banner(
                    obj.get("pic").getAsString(),
                    obj.get("url").getAsString(),
                    obj.get("targetType").getAsInt(),
                    obj.get("targetId").getAsLong(),
                    obj.get("titleColor").getAsString(),
                    obj.get("typeTitle").getAsString(),
                    obj.get("encodeId").getAsString()
            );
            result.add(banner);
        }
        return result;
    }
}
