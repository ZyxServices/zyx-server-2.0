package com.zyx.vo.record;

/**
 * Created by MrDeng on 2016/11/7.
 * 运动情况概览
 */
public class SportOverviewVo {
    /**
     * 运动次数
     */
    private Integer sportTimes;
    /**
     * 总分
     */
    private Integer totalScore;
    /**
     * 足迹个数
     */
    private Integer fpNumber;

    /**
     * 城市数量
     */
    private Integer cityNumber;

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
