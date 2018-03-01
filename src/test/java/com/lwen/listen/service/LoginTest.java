package com.lwen.listen.service;

import com.google.gson.Gson;
import com.lwen.listen.spider.Spider;
import com.lwen.listen.util.AesCBC;
import com.lwen.listen.utils.EncryptTools;
import lombok.experimental.var;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.math.BigInteger;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

class Result {
    public String params;
    public String encSecKey;

    public Result(String params, String encSecKey) {
        this.params = params;
        this.encSecKey = encSecKey;
    }

    @Override
    public String toString() {
        return "Result{" +
                "params='" + params + '\'' +
                ", encSecKey='" + encSecKey + '\'' +
                '}';
    }
}


class Hex{
    public static String encodeHexString(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

}

public class LoginTest {


    @Test
    public void commentAPI() throws Exception {
        //私钥，随机16位字符串（自己可改）
        String secKey = "cd859f54539b24b7";
        String text = "{\"username\": \"\", \"rememberLogin\": \"true\", \"password\": \"\"}";
        String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
        String nonce = "0CoJUm6Qyw8W8jud";
        String pubKey = "010001";
        //2次AES加密，得到params
        String params = EncryptTools.aesEncrypt(EncryptTools.aesEncrypt(text, nonce), secKey);
        StringBuffer stringBuffer = new StringBuffer(secKey);
        //逆置私钥
        secKey = stringBuffer.reverse().toString();
        String hex = Hex.encodeHexString(secKey.getBytes());
        BigInteger bigInteger1 = new BigInteger(hex, 16);
        BigInteger bigInteger2 = new BigInteger(pubKey, 16);
        BigInteger bigInteger3 = new BigInteger(modulus, 16);
        //RSA加密计算
        BigInteger bigInteger4 = bigInteger1.pow(bigInteger2.intValue()).remainder(bigInteger3);
        String encSecKey= Hex.encodeHexString(bigInteger4.toByteArray());
        //字符填充
        encSecKey= EncryptTools.zfill(encSecKey, 256);
        //评论获取
        Document document = Jsoup.connect("http://music.163.com/weapi/v1/resource/comments/R_SO_4_437859519/").cookie("appver", "1.5.0.75771")
                .header("Referer", "http://music.163.com/").data("params", params).data("encSecKey", encSecKey)
                .ignoreContentType(true).post();
        System.out.println("评论：" + document.text());
    }

    @Test
    public void loginAPI() throws Exception {
        String username="15686070023";
        String password="sh19970618";
        password = EncryptTools.md5(password);
        // 私钥，随机16位字符串（自己可改）
        // String secKey = "cd859f54539b24b7";
        String text = "{\"phone\":\""+username+"\",\"password\":\""+password+"\",\"rememberLogin\":\"true\"}\n";
        String secKey =  EncryptTools.createSecretKey(16);
        String nonce = "0CoJUm6Qyw8W8jud";
        // 2次AES加密，得到params
        String params = EncryptTools.aesEncrypt(EncryptTools.aesEncrypt(text, nonce), secKey);
        //RAS 得到encSecKey
        String encSecKey = EncryptTools.rasEncrypt(secKey);
        // 登录请求
        Document document =
                Jsoup.connect("http://music.163.com/weapi/login/cellphone")
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
        System.out.println("登录结果：" + document.text());
    }


    // @Test
    // public void login() throws Exception {
    //     Map<String, String> headers = new HashMap<>();
    //     Map<String, String> data = new HashMap<>();
    //     Map<String, String> cookie = new HashMap<>();
    //     HashMap<String, String> date = new HashMap<>();
    //     date.put("csrf_token", "");
    //     Result result = Encrypt(date);
    //     System.out.println(result);
    //     data.put("params", result.params);
    //     data.put("encSecKey", result.encSecKey);
    //     Spider spider = new Spider(headers, "http://music.163.com/api/login/cellphone", data, cookie);
    //     Document document = spider.postRequest();
    //     System.out.println(document.body().html());
    // }

    // public Result Encrypt(Map<String, String> data) throws Exception {
    //     final String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b3ece0462db0a22b8e7";
    //     final String pubKey = "010001";
    //     final String nonce = "0CoJUm6Qyw8W8jud";
    //     String json = mapToJson(data);
    //     String secKey = createSecretKey(16);
    //     System.out.println(secKey);
    //     String encText = aesEncrypt(aesEncrypt(json, nonce), secKey);
    //     String encSecKey = rsaEncrypt(secKey, pubKey, modulus);
    //     return new Result(encText, encSecKey);
    // }
    //
    // public String mapToJson(Map<String, String> data) {
    //     StringBuilder json = new StringBuilder();
    //     json.append("{");
    //     for (Map.Entry<String, String> entry : data.entrySet()) {
    //         json.append("\"" + entry.getKey() + "\":" + "\"" + entry.getValue() + "\",");
    //     }
    //     json.deleteCharAt(json.length() - 1);
    //     json.append("}");
    //     return json.toString();
    // }
    //
    // public String createSecretKey(int size) {
    //     String keys = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    //     StringBuilder key = new StringBuilder();
    //     for (int i = 0; i < size; i++) {
    //         double pos = Math.random() * keys.length();
    //         pos = Math.floor(pos);
    //         key.append(keys.charAt((int) pos));
    //     }
    //     return key.toString();
    // }
    //
    // public String aesEncrypt(String text, String secKey) throws Exception {
    //     String lv = "0102030405060708";
    //     String encrypted = AesCBC.getInstance().encrypt(text, "utf-8", secKey, lv);
    //     return encrypted;
    // }
    //
    //
    // public String rsaEncrypt(String text, String pubKey, String modulus) {
    //     String _text = new StringBuilder(text).reverse().toString();
    //     BigInteger biText = new BigInteger(printHexString(_text), 16);
    //     BigInteger biEx = new BigInteger(pubKey, 16);
    //     BigInteger biMod = new BigInteger(modulus, 16);
    //     BigInteger biRet = biText.modPow(biEx, biMod);
    //     return zfill(biRet.toString(16), 256);
    // }
    //
    // public String zfill(String str, int size) {
    //     StringBuilder strBuilder = new StringBuilder(str);
    //     while (strBuilder.length() < size) strBuilder.insert(0, "0");
    //     str = strBuilder.toString();
    //     return str;
    // }
    //
    // public String printHexString(String hint) {
    //     StringBuilder builder = new StringBuilder();
    //     byte[] b = hint.getBytes();
    //     for (int i = 0; i < b.length; i++) {
    //         String hex = Integer.toHexString(b[i] & 0xFF);
    //         if (hex.length() == 1) {
    //             hex = '0' + hex;
    //         }
    //         builder.append(hex.toUpperCase());
    //     }
    //     return builder.toString();
    // }

}
