package com.zyx.vo.record;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/11/7.
 * 运动情况概览
 */
public class SportOverviewVo implements Serializable{
    /**
     * 运动次数
     */
    private Integer sportTimes=0;
    /**
     * 总分
     */
    private Integer totalScore=0;
    /**
     * 足迹个数
     */
    private Integer fpNumber=0;

    /**
     * 城市数量
     */
    private Integer cityNumber=0;

    public Integer getSportTimes() {
        return sportTimes;
    }

    public void setSportTimes(Integer sportTimes) {
        this.sportTimes = sportTimes;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getFpNumber() {
        return fpNumber;
    }

    public void setFpNumber(Integer fpNumber) {
        this.fpNumber = fpNumber;
    }

    public Integer getCityNumber() {
        return cityNumber;
    }

    public void setCityNumber(Integer cityNumber) {
        this.cityNumber = cityNumber;
    }
}
