package com.lwen.listen.spider;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SpiderTest {
    private Map<String, String> headers = new HashMap<String, String>();
    private String url="http://music.163.com/api/playlist/list";
    private Map<String, String> cookie = new HashMap<String, String>();
    private Map<String, String> data = new HashMap<String, String>();
    private Spider spider;

   public SpiderTest(){
       data.put("cat", "全部");
       data.put("limit", "10");
       spider = new Spider(headers,url,data,cookie);
   }


    @Test
    public void mapToString(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "12");
        map.put("b", "11");
        map.put("c", "10");
//        System.out.println(spider.mapToString(map));
    }

    @Test
    public void testPostAndGet(){
        System.out.println(spider.getRequest());
    }
}