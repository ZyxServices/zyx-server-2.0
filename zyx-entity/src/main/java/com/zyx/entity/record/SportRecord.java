package com.zyx.entity.record;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * Created by MrDeng on 2016/11/4.
 * 运动记录
 */
@Table(name = "t_sport_record")
public class SportRecord extends BaseEntity{
    private Integer userId;
    private Integer type;
//    private String level;
    private Integer venueId;
    /**
     * 运动场馆编号
     */
    private Integer sportInfoId;
    /**
     * 运动时间
     */
    private Long spendTime;
//    /**
//     * 荣誉值得分
//     */
//    private Integer score;

    private Integer concernId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

//    public String getLevel() {
//        return level;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }


    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getSportInfoId() {
        return sportInfoId;
    }

    public void setSportInfoId(Integer sportInfoId) {
        this.sportInfoId = sportInfoId;
    }

    public Long getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Long spendTime) {
        this.spendTime = spendTime;
    }

//    public Integer getScore() {
//        return score;
//    }
//
//    public void setScore(Integer score) {
//        this.score = score;
//    }

    public Integer getConcernId() {
        return concernId;
    }

    public void setConcernId(Integer concernId) {
        this.concernId = concernId;
    }
}
