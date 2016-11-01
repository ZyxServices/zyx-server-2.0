package com.zyx.param.coin;

/**
 * Created by MrDeng on 2016/10/31.
 */
public class SportCoinParam {
    private Integer userId;
    private Integer operType;
    private Long coinNum;
    private Integer modelId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public Long getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(Long coinNum) {
        this.coinNum = coinNum;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
}
