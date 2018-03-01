package com.lwen.listen.service;

import com.lwen.listen.entity.User;
import com.lwen.listen.spider.Spider;
import com.lwen.listen.utils.EncryptTools;
import org.springframework.stereotype.Component;

@Component
public class LoginService extends HomeService{

    private String login(String username, String password,String type) throws Exception {
        password = EncryptTools.md5(password);
        String text = "";
        if (type.equals("phone")) {
            text = "{\"phone\":\""+username+"\",\"password\":\""+password+"\",\"rememberLogin\":\"true\"}";
        }else {
            text = "{\"username\":\""+username+"\",\"password\":\""+password+"\",\"rememberLogin\":\"true\"}";
        }
        String secKey =  EncryptTools.createSecretKey(16);
        String nonce = "0CoJUm6Qyw8W8jud";
        String params = EncryptTools.aesEncrypt(EncryptTools.aesEncrypt(text, nonce), secKey);
        String encSecKey = EncryptTools.rasEncrypt(secKey);
        if (type.equals("phone")) {
            return Spider.postRequest("http://music.163.com/weapi/login/cellphone", text);
        }else {
            return Spider.postRequest("http://music.163.com/weapi/login", text);
        }
    }

    public String clogin(String phone, String password) throws Exception {
        return login(phone, password, "phone");
    }

    public String elogin(String email, String password) throws Exception {
        return login(email, password, "email");
    }


    public String subcoun(String id) {
        return Spider.postRequest("http://music.163.com/weapi/subcount", "{\"userId\":\"" + id + "\",\"csrf_token\":\"\"}");
    }
}
