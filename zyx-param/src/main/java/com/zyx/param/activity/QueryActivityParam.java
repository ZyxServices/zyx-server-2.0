package com.zyx.param.activity;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/7
 */
public class QueryActivityParam implements Serializable {

    /**
     * 活动状态（0、全部  1、正在报名 2、已结束）
     */
    private Integer activityState;

    /**
     * 活动类型（0、全部 1、求约 2、求带）
     */
    private Integer activityType;

    /**
     * 每页显示多少条
     */
    private Integer number;

    /**
     * 第几页
     */
    private Integer pageNumber;

    /**
     * 当前时间
     */
    private Long nowTime;

    /**
     * 活动发布城市
     */
    private String city;

    /**
     * 是否编辑
     */
    private Integer editState;

    private Integer userId;

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getNowTime() {
        return nowTime;
    }

    public void setNowTime(Long nowTime) {
        this.nowTime = nowTime;
    }

    public Integer getEditState() {
        return editState;
    }

    public void setEditState(Integer editState) {
        this.editState = editState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
