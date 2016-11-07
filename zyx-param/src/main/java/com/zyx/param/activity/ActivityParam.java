package com.zyx.param.activity;

import java.io.Serializable;

/**
 * Created by Rainbow on 2016/11/3.
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
}
