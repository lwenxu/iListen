package com.lwen.listen.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table @Data @NoArgsConstructor @AllArgsConstructor
public class PlayList {
    @Id private Long listId ;
    private String listName ;
    private String username ;
    private String coverImgUrl ;
    private Long playCount;
    private Long trackCount;
    private Long bookCount;
    private Long userId;
}
