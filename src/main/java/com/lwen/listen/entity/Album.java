package com.lwen.listen.entity;


import lombok.*;

import javax.persistence.*;

@Entity @Table @Data @NoArgsConstructor @AllArgsConstructor
public class Album {
    @Id private Long aId;
    private String name;
    @OneToOne @JoinColumn private Artist artist;
    private String publishTime;
    private Integer size;
}
