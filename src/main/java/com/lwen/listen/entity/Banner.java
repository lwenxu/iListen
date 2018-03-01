package com.lwen.listen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Native;

@Entity
@Table
public class Banner {
    @Id@Native
    private Long id;
    private String pic;
    private String url;
    private int targetType;
    private long targetId;
    private String titleColor;
    private String typeTitle;
    private String encodeId;

    public Banner(String pic, String url, int targetType, long targetId, String titleColor, String typeTitle, String encodeId) {
        this.pic = pic;
        this.url = url;
        this.targetType = targetType;
        this.targetId = targetId;
        this.titleColor = titleColor;
        this.typeTitle = typeTitle;
        this.encodeId = encodeId;
    }

    public Banner() {
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    public String getPic() {
        return pic;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }
    public int getTargetType() {
        return targetType;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
    }
    public long getTargetId() {
        return targetId;
    }

    public void setTitleColor(String titleColor) {
        this.titleColor = titleColor;
    }
    public String getTitleColor() {
        return titleColor;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }
    public String getTypeTitle() {
        return typeTitle;
    }

    public void setEncodeId(String encodeId) {
        this.encodeId = encodeId;
    }
    public String getEncodeId() {
        return encodeId;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "pic='" + pic + '\'' +
                ", url='" + url + '\'' +
                ", targetType=" + targetType +
                ", targetId=" + targetId +
                ", titleColor='" + titleColor + '\'' +
                ", typeTitle='" + typeTitle + '\'' +
                ", encodeId='" + encodeId + '\'' +
                '}';
    }
}