package com.zyx.param.activity;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/3
 */
public class ActivityParam implements Serializable {

    /**
     * 创建者ID
     */
    private Integer userId;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动内容
     */
    private String desc;

    /**
     * 活动封面图片
     */
    private String imgUrls;

    /**
     * 活动类型（0 求约/ 1 求带）
     */
    private Integer type;

    /**
     * 活动开始时间
     */
    private Long startTime;

    /**
     * 活动结束时间
     */
    private Long endTime;

    /**
     * 报名截至时间
     */
    private Long lastTime;

    /**
     * 活动地址
     */
    private String address;

    /**
     * 活动地址
     */
    private String city;

    /**
     * 活动分类模块
     * （活动模块（1攀岩 2跑步 3羽毛球 4网球 4单车 5滑雪 6见面会））
     */
    private Integer activityModule;

    /**
     * 付费类型（0奖励 1免费 2AA）
     */
    private Integer paymentType;

    /**
     * 报名人数
     */
    private Integer maxPepople;

    /**
     * 活动费用
     */
    private Double price;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMaxPepople() {
        return maxPepople;
    }

    public void setMaxPepople(Integer maxPepople) {
        this.maxPepople = maxPepople;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getActivityModule() {
        return activityModule;
    }

    public void setActivityModule(Integer activityModule) {
        this.activityModule = activityModule;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
