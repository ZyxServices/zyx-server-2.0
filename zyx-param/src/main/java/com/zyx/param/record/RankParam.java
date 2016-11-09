package com.zyx.param.record;

import com.zyx.param.Pager;

/**
 * Created by MrDeng on 2016/11/4.
 * 排行查询参数
 */
public class RankParam extends Pager{
    private Integer userId;
    private Integer startTime;
    private Integer endTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
