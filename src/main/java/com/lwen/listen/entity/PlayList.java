package com.lwen.listen.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
    @JoinColumn @OneToOne private User createUser;
//    @ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
//    @JoinTable(name="playlist_tags",joinColumns={@JoinColumn(name="t_id")},inverseJoinColumns={@JoinColumn(name="p_id")})
    @JoinColumn @ManyToMany private Set<Tag> tags;
    @JoinColumn @ManyToMany private Set<Music> musics;
}
