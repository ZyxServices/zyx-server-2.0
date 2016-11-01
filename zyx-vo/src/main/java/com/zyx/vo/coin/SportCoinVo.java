package com.zyx.vo.coin;

/**
 * Created by MrDeng on 2016/10/31.
 */
public class SportCoinVo {
    private Integer userId;
    private Long coin;
    private Integer state;

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
