package com.lwen.listen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table @Component @Data @NoArgsConstructor @AllArgsConstructor
public class Tag {
    @Id private Integer id;
    private String typeName;
}
