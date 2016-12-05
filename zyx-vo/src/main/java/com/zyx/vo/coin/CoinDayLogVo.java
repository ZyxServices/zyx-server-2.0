package com.zyx.vo.coin;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/12/1.
 *
 * 货币记录每日统计日志
 */
public class CoinDayLogVo implements Serializable{
    Integer operId;
    Integer operTimes;

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public Integer getOperTimes() {
        return operTimes;
    }

    public void setOperTimes(Integer operTimes) {
        this.operTimes = operTimes;
    }
}
