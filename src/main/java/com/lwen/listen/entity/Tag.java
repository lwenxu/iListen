package com.lwen.listen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Tag {

    private boolean hot;
    private long usedCount;
    private long createTime;
    private int position;
    private int category;
    private String name;
    @Id private int id;
    private int type;

    public void setHot(boolean hot) {
        this.hot = hot;
    }
    public boolean getHot() {
        return hot;
    }

    public void setUsedCount(long usedCount) {
        this.usedCount = usedCount;
    }
    public long getUsedCount() {
        return usedCount;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
    public long getCreateTime() {
        return createTime;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    public int getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }

    public Tag(boolean hot, long usedCount, long createTime, int position, int category, String name, int id, int type) {
        this.hot = hot;
        this.usedCount = usedCount;
        this.createTime = createTime;
        this.position = position;
        this.category = category;
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public Tag() {
    }
}