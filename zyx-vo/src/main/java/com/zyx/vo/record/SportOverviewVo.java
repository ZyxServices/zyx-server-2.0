package com.zyx.vo.record;

/**
 * Created by MrDeng on 2016/11/7.
 * 运动情况概览
 */
public class SportOverviewVo {
    /**
     * 运动次数
     */
    private Integer sportTime;
    /**
     * 总分
     */
    private Integer totalScore;
    /**
     * 足迹个数
     */
    private Integer fpNumber;

    public Integer getSportTime() {
        return sportTime;
    }

    public void setSportTime(Integer sportTime) {
        this.sportTime = sportTime;
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
}
