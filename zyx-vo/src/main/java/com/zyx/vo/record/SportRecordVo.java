package com.zyx.vo.record;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/11/4.
 */
public class SportRecordVo implements Serializable {
    private Integer id;
    private Long createTime;
    private Integer userId;
    private Integer sportInfoId;
    private Integer score;
    /**
     * 运动时间
     */
    private Long spendTime;
    /**
     * 对应show动态ID
     */
    private Integer concenId;


    /**
     * 运动场馆编号
     */
    private Integer venueId;
    private String venueName;
    /**
     *
     */
    private String path;
    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSportInfoId() {
        return sportInfoId;
    }

    public void setSportInfoId(Integer sportInfoId) {
        this.sportInfoId = sportInfoId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Long spendTime) {
        this.spendTime = spendTime;
    }

    public Integer getConcenId() {
        return concenId;
    }

    public void setConcenId(Integer concenId) {
        this.concenId = concenId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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
}
