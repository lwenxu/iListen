package com.lwen.listen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity @Table @Data @NoArgsConstructor @AllArgsConstructor
public class Music {
    @Id private Long id;
    private String name;
    private String alias ;
    private String copyrightId ;
    private List<Artist> artists;
    private Album album ;
    private Boolean starred ;
    private String crbt ;
    private String commentId;
    private Long mvid;
    private String mp3Url ;
    private Long highId ;
    private Long mediumId ;
    private Long lowId;
    
    
    
//    @Id private Long mId;
//    private String name;
//    @ManyToOne @JoinColumn private Artist artist;
//    @ManyToOne @JoinColumn private Album album;
//    private String dfsId;
//    private String url;
//    private Long times;
}
