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
     * 活动图片
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String imgUrls;

    /**
     * 活动描述
     */
    @Column
    @ColumnType(jdbcType = JdbcType.LONGVARCHAR)
    private String descContent;

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
     * 活动可见范围 0 所有可见, 1 朋友可见
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer visible;

    /**
     * 咨询电话
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String phone;

    /**
     * 活动价格
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private double price;

    /**
     * 活动分类
     * 0 线上活动, 1  线下活动
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer type;

    /**
     * 线上活动跳转地址
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String targetUrl;

    /**
     * 活动地址
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String address;

    /**
     * 活动是否需要审核（活动发起者审核）
     * 0 不许要审核 , 1 需要审核
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer examine;

    /**
     * 报名活动模板
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String memberTemplate;

    /**
     * 是否屏蔽（0正常 1屏蔽）
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer mask;

}
