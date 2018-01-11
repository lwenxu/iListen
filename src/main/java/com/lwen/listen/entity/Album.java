package com.lwen.listen.entity;


import lombok.*;

import javax.persistence.*;

@Entity @Table @Data @NoArgsConstructor @AllArgsConstructor
public class Album {
    @Id private Long id;
    private String name;
    private Integer size;
    private String blurPicUrl;
    private String picUrl;
    private String publishTime;
    private String description;
    private String tags;
    private String company;
    private String briefDesc;
    private Artist artists;
    private String commentThreadId;
//    @Id private Long aId;
//    private String name;
//    @OneToOne @JoinColumn private Artist artist;
//    private String publishTime;
//    private Integer size;
}
