package com.lwen.listen.service;

import com.github.kevinsawicki.http.HttpRequest;
import com.lwen.listen.spider.Spider;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class APITest {
    @Test
    public void request() throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "*/*");
        headers.put("Accept-Language", "zh-CNzh;q=0.8gl;q=0.6zh-TW;q=0.4");
        headers.put("Connection", "keep-alive");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Referer", "http,//music.163.com");
        headers.put("Host", "music.163.com");
        headers.put("Cookie", "");
        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML like Gecko) Version/9.0 Mobile/13B143 Safari/601.1");
        Map<String, String> data = new HashMap<>();
        Map<String, String> cookie = new HashMap<>();
        HashMap<String, String> date = new HashMap<>();

        // Connection connection = Jsoup.connect("http://music.163.com/weapi/playlist/catalogue");
        // connection.headers(headers);
        // connection.data(data);
        // // System.out.println(connection.request().requestBody());;
        // if (connection.request().requestBody()==null) {
        //     request();
        //     return;
        // }

        String resp = HttpRequest.post("http://music.163.com/weapi/playlist/catalogue").trustAllCerts().trustAllHosts()
                .form(data)
                .connectTimeout(60000)
                .readTimeout(60000)
                .body();

        if (resp.equals("")) {
            System.out.println(resp+"============");
            request();
            return;
        }


        // Spider spider = new Spider(headers, "http://music.163.com/weapi/playlist/catalogue", data, cookie);
        // Document doc = spider.postRequest();
        // System.out.println(doc.body().html());
        // String text = doc.body().html();
        // System.out.println(doc);
        // if (Objects.equals(text, "")) {
        //     request();
        //     return;
        // }
    }
}
