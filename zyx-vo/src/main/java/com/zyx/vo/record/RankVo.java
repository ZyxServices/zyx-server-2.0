package com.zyx.vo.record;

import com.zyx.vo.account.UserIconVo;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/11/4.
 *
 * 用户运动记录排行
 */
public class RankVo implements Serializable {
    /**
     * 排序
     */
    private Integer rankNum;
    private Integer userId;
    private UserIconVo userIconVo;
    private Integer totalScore;

    public Integer getRankNum() {
        return rankNum;
    }

    public void setRankNum(Integer rankNum) {
        this.rankNum = rankNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserIconVo getUserIconVo() {
        return userIconVo;
    }

    public void setUserIconVo(UserIconVo userIconVo) {
        this.userIconVo = userIconVo;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }
}
