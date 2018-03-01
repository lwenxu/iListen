package com.lwen.listen.service;

import com.lwen.listen.spider.Spider;
import org.hibernate.validator.internal.metadata.aggregated.ValidatableParametersMetaData;
import org.springframework.stereotype.Component;

@Component
public class TagListService extends HomeService {

    public String getTagListJson() throws Exception {
        return Spider.postRequest("http://music.163.com/weapi/playlist/catalogue", "{\"csrf_token\":\"\"}");
    }

}
