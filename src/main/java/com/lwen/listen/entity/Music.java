package com.lwen.listen.entity;

import lombok.*;

import javax.persistence.*;

@Entity @Table @Data @NoArgsConstructor @AllArgsConstructor
public class Music {
    @Id private Long mId;
    private String name;
    @ManyToOne @JoinColumn private Artist artist;
    @ManyToOne @JoinColumn private Album album;
    private String dfsId;
    private String url;
    private Long times;
}
