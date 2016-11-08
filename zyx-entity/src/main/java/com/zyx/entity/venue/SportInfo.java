package com.zyx.entity.venue;

import javax.persistence.Table;

/**
 * Created by MrDeng on 2016/11/4.
 * 运动场馆难度等级
 */
@Table(name = "t_sport-info")
public class SportInfo {
    private Integer id;
    /**
     * 所属场馆ID
     */
    private Integer venueId;
    /**
     * 路线名称  可以为空
     */
    private String path;
    /**
     * 路线难度
     */
    private String level;

    /**
     * 难度对应得分
     */
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
