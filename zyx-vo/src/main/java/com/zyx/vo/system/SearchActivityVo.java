package com.zyx.vo.system;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/9
 */
public class SearchActivityVo implements Serializable {
    /**
     * 主键ID
     **/
    private Integer id;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动封面
     */
    private String imgUrl;

    /**
     * 活动类型(1、求约 2、求带)
     */
    private String activityType;

    /**
     * 活动人数上限
     */
    private Integer maxPeople;

    /**
     * 已报名人数
     */
    private Integer alreadyPeople;

    /**
     * 付费类型（0、奖励 1、免费 2、AA）
     */
    private Integer paymentType;

    /**
     * 活动价格
     */
    private double price;

    /**
     * 创建时间
     */
    private Long createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        if (activityType == 1) {
            this.activityType = "求约";
        } else if (activityType == 2) {
            this.activityType = "求带";
        } else {
            this.activityType = "求约";
        }
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Integer getAlreadyPeople() {
        return alreadyPeople;
    }

    public void setAlreadyPeople(Integer alreadyPeople) {
        this.alreadyPeople = alreadyPeople;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
