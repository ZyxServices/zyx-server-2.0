package com.zyx.param.record;

import com.zyx.param.Pager;

/**
 * Created by MrDeng on 2016/11/4.
 */
public class SportRecordParam extends Pager {

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
