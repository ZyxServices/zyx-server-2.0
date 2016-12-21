package com.zyx.vo.activity;

import com.zyx.vo.account.AccountAttentionVo;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/24
 */
public class ActivityListVo implements Serializable {

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
     * 活动图片
     */
    private String imgUrls;

    /**
     * 活动分类
     * 0 求约, 1 求带
     */
    private Integer activityType;

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
     * 付费类型（0奖励 1免费 2AA）
     */
    private Integer paymentType;

    /**
     * 活动报名人数
     */
    private Integer memberPeople;


    /**
     * 城市
     */
    private String city;

    /**
     * 活动价格
     */
    private double price;

    /**
     * 点赞
     */
    private Integer zan;

    /**
     * 评论
     */
    private Integer commentNumber;

    private Long createTime;

    private boolean toZan;

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

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getMemberPeople() {
        return memberPeople;
    }

    public void setMemberPeople(Integer memberPeople) {
        this.memberPeople = memberPeople;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isToZan() {
        return toZan;
    }

    public void setToZan(int toZan) {
        if(toZan <= 0){
            this.toZan = false;
        }else{
            this.toZan = true;
        }
    }
}
