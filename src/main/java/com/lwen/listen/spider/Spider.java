package com.lwen.listen.spider;


import com.lwen.listen.utils.EncryptTools;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Spider {
    private Map<String,String> headers;
    private String url;
    private Connection con;
    private Map<String, String> cookie;
    private Map<String,String> data;

    public Spider(Map<String,String> headers, String url, Map<String,String> data, Map<String,String> cookie){
        this.headers = headers;
        this.data = data;
        this.cookie = cookie;
        this.url = url;
//        generateUrl();
        this.con = Jsoup.connect(url);
    }

    /**
     * 初始化操作  主要是对 connection 属性进行设置
     */
    private void init(){
        con.data(data);
        con.headers(headers);
        con.cookies(cookie);
        con.url(url);
    }

    /**
     * post 方式进行请求数据  返回 document 节点
     * @return Document
     *
     */
    public static String postRequest(String url,String data) {
        String secKey =  EncryptTools.createSecretKey(16);
        String nonce = "0CoJUm6Qyw8W8jud";
        // 2次AES加密，得到params
        String params = null;
        try {
            params = EncryptTools.aesEncrypt(EncryptTools.aesEncrypt(data, nonce), secKey);
        } catch (Exception e) {
            System.out.println("加密失败");
             e.printStackTrace();
        }
        //RAS 得到encSecKey
        String encSecKey = EncryptTools.rasEncrypt(secKey);
        // 登录请求
        Document document =
                null;
        try {
            document = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Referer", "http://music.163.com/")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,gl;q=0.6,zh-TW;q=0.4")
                    .header("Connection", "keep-alive")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Host", "music.163.com")
                    .header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1")
                    .data("params", params)
                    .data("encSecKey", encSecKey)
                    .ignoreContentType(true)
                    .post();
        } catch (IOException e) {
            System.out.println("POST 请求失败！");
            e.printStackTrace();
        }
        return document.text();
    }


    public static String getRequest(String url, String query) {
        url = url + "?" + query;
        Document document =
                null;
        try {
            document = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Referer", "http://music.163.com/")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,gl;q=0.6,zh-TW;q=0.4")
                    .header("Connection", "keep-alive")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Host", "music.163.com")
                    .header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1")
                    .ignoreContentType(true)
                    .get();
        } catch (IOException e) {
            System.out.println("GET 请求失败");
        }
        return document.text();
    }

    public static String postRequest(String url,
                                     Map<String, String> header,
                                     Map<String, String> data,
                                     Map<String, String> cookie) {
        Connection connection = Jsoup.connect(url);
        connection.headers(header);
        connection.data(data);
        connection.cookies(cookie);
        String text = "";
        try {
            text = connection.post().text();
        } catch (IOException e) {
            System.out.println("post 失败！");
        }
        return text;
    }

    /**
     * get 方式进行请求数据  返回 document 节点
     * @return Document
     *
     */
    public Document getRequest(){
        init();
        Document result = null;
        try {
            result = con.ignoreContentType(true).get();
        } catch (IOException e) {
            System.out.println("GET 请求错误 !");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 将 map 数据转化为 url query string
     * @param data Map<String,String>
     * @return String
     */
    private String mapToString(Map<String,String> data){
        if (data.isEmpty()) {
            return "";
        }
        Set<Map.Entry<String, String>> entries = data.entrySet();
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : entries) {
            builder.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    /**
     * 生成真正的 Url
     */
    private void generateUrl(){
//        System.out.println(this.url);
//        System.out.println(mapToString(this.data));
//        this.url = "";
        this.url = this.url + mapToString(this.data);
    }

}
