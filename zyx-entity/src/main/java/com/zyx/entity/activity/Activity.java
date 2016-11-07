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
    private Integer type;

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
     * 活动价格
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private double price;

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

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }
}
