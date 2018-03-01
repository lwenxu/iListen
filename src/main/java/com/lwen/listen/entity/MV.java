package com.lwen.listen.entity;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table
public class MV {

    @Id private long id;
    private int type;
    private String name;
    private String copywriter;
    private String picUrl;
    private boolean canDislike;
    private long duration;
    private int playCount;
    private boolean subed;
    @JoinColumn @ManyToMany private Set<Artist> artists;
    private String artistName;
    private int artistId;
    private String alg;

    public MV() {
    }

    public MV(long id, int type, String name, String copywriter, String picUrl, boolean canDislike, long duration, int playCount, boolean subed, Set<Artist> artists, String artistName, int artistId, String alg) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.copywriter = copywriter;
        this.picUrl = picUrl;
        this.canDislike = canDislike;
        this.duration = duration;
        this.playCount = playCount;
        this.subed = subed;
        this.artists = artists;
        this.artistName = artistName;
        this.artistId = artistId;
        this.alg = alg;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setType(int type) {
        this.type = type;
    }
    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setCopywriter(String copywriter) {
        this.copywriter = copywriter;
    }
    public String getCopywriter() {
        return copywriter;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    public String getPicUrl() {
        return picUrl;
    }

    public void setCanDislike(boolean canDislike) {
        this.canDislike = canDislike;
    }
    public boolean getCanDislike() {
        return canDislike;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
    public long getDuration() {
        return duration;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }
    public int getPlayCount() {
        return playCount;
    }

    public void setSubed(boolean subed) {
        this.subed = subed;
    }
    public boolean getSubed() {
        return subed;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }
    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    public String getArtistName() {
        return artistName;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
    public int getArtistId() {
        return artistId;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }
    public String getAlg() {
        return alg;
    }

    @Override
    public String toString() {
        return "MV{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", copywriter='" + copywriter + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", canDislike=" + canDislike +
                ", duration=" + duration +
                ", playCount=" + playCount +
                ", subed=" + subed +
                ", artists=" + artists +
                ", artistName='" + artistName + '\'' +
                ", artistId=" + artistId +
                ", alg='" + alg + '\'' +
                '}';
    }
}