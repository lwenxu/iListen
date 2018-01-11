package com.lwen.listen.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table @Data @NoArgsConstructor @AllArgsConstructor
public class Artist {
    @Id @NotFound(action= NotFoundAction.IGNORE) private Long id;
    @Column(nullable = false) private String name;
    private String imgUrl;
}
