package com.zyx.vo.activity;

import com.zyx.vo.account.AccountAttentionVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/7
 */
public class ActivityVo implements Serializable {

    private Integer id;

    /**
     * 创建者(用户ID)
     */
    private AccountAttentionVo user;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动描述
     */
    private String descContent;

    /**
     * 活动图片
     */
    private String imgUrls;

    /**
     * 活动分类
     * 0 求约, 1 求带
     */
    private Integer activityType;

    /**
     * 活动分类模块
     * （活动模块（1攀岩 2跑步 3羽毛球 4网球 4单车 5滑雪 6见面会））
     */
    private Integer activityModule;

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
     * 活动人数上限
     */
    private Integer maxPeople;

    /**
     * 活动地址
     */
    private String address;

    /**
     * 活动发布城市
     */
    private String city;

    /**
     * 付费类型（0奖励 1免费 2AA）
     */
    private Integer paymentType;

    /**
     * 活动价格
     */
    private double price;

    /**
     * 线上地址
     */
    private String targetUrl;

    /**
     * 创建时间
     **/
    private Long createTime;

    /**
     * 编辑状态下返回内容图片URL
     */
    private List<String> editDescImgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AccountAttentionVo getUser() {
        return user;
    }

    public void setUser(AccountAttentionVo user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescContent() {
        return descContent;
    }

    public void setDescContent(String descContent) {
        this.descContent = descContent;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getActivityModule() {
        return activityModule;
    }

    public void setActivityModule(Integer activityModule) {
        this.activityModule = activityModule;
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

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public List<String> getEditDescImgUrl() {
        return editDescImgUrl;
    }

    public void setEditDescImgUrl(List<String> editDescImgUrl) {
        this.editDescImgUrl = editDescImgUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }
}
