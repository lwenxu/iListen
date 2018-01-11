package com.lwen.listen.spider;


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
    public String postRequest(){
        init();
        Document result = null;
        try {
            result = con.post();
        } catch (IOException e) {
            System.out.println("POST 请求错误 !");
            e.printStackTrace();
        }
        return result.body().html();
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
