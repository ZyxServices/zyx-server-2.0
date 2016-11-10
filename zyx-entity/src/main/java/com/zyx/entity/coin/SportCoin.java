package com.zyx.entity.coin;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Table(name = "t_sport_coin")
public class SportCoin extends BaseEntity {
    private Long modifyTime;
    private Integer userId;
    private Long coin;
    private Integer state;

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getCoin() {
        return coin;
    }

    public void setCoin(Long coin) {
        this.coin = coin;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
