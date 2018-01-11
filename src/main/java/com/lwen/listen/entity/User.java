package com.lwen.listen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User {
    private String birthday;
    private String detailDescription;
    private String backgroundUrl;
    private Integer gender;  //1 man 2 women
    private String signature;
    private String description;
    private String nickname;
    private String avatarUrl;
    @Id private Long userId;
}
