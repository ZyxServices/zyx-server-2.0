package com.zyx.param.record;

import com.zyx.param.Pager;

/**
 * Created by MrDeng on 2016/11/4.
 * 排行查询参数
 */
public class RankParam extends Pager{
    private Integer userId;
    private Integer start;
    private Integer end;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
