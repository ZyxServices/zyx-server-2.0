package com.zyx.entity.coin;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Table(name = "t_coin_log")
public class CoinLog extends BaseEntity{
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 操作编号
     */
    private Integer operId;
    /**
     * 关联模块ID  可为空
     */
    private Integer modelId;
    /**
     * 运动币操作数量
     */
    private Long coinNum;

    /**
     * 操作结果状态
     * -1 操作出错 为完成
     * -  操作正常完成
     */
    private Integer state;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }


    public Long getCoinNum() {
        return coinNum;
    }

    public void setCoinNum(Long coinNum) {
        this.coinNum = coinNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
