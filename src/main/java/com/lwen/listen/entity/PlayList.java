package com.lwen.listen.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity @Table @Data @NoArgsConstructor @AllArgsConstructor
public class PlayList {
    @Id private Long id;
    private String name;
    private String updateTime;
    private String createTime;
    private Long uid;
    private Long subscribedCount;
    private Long trackCount;
    private String coverImgUrl;
    private String description;
    private Long playCount;
    private String commentId;
    private Long shareCount;
    private Long commentCount;
    private User createUser;
    private List<Tag> tags;
    private List<Music> musics;
}
