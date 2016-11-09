package com.zyx.entity.activity;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;

/**
 * Created by Rainbow on 2016/10/25.
 */
public class Activity extends BaseEntity {
    /**
     * 创建者(用户ID)
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;

    /**
     * 活动标题
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String title;

    /**
     * 活动描述
     */
    @Column
    @ColumnType(jdbcType = JdbcType.LONGVARCHAR)
    private String descContent;

    /**
     * 活动图片
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String imgUrls;

    /**
     * 活动分类
     * 0 求约, 1 求带
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer activityType;

    /**
     * 活动分类模块
     * （活动模块（1攀岩 2跑步 3羽毛球 4网球 4单车 5滑雪 6见面会））
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer activityModule;

    /**
     * 活动开始时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long startTime;

    /**
     * 活动结束时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long endTime;

    /**
     * 报名截至时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long lastTime;

    /**
     * 活动人数上限
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer maxPeople;

    /**
     * 活动地址
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String address;

    /**
     * 活动发布城市
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String city;
    /**
     * 活动价格
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private double price;

    /**
     * 线上地址
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String targetUrl;

    /**
     * 活动是否删除(0正常， 1删除)
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer del;

    /**
     * 是否屏蔽（0正常 1屏蔽）
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer mask;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public Integer getActivityModule() {
        return activityModule;
    }

    public void setActivityModule(Integer activityModule) {
        this.activityModule = activityModule;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}
