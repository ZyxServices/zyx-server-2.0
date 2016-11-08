package com.zyx.vo.record;

/**
 * Created by MrDeng on 2016/11/8.
 * 运动记录详情
 */
public class RecordInfoVo {
    /**
     * 运动类型
     */
    private Integer type;
    /**
     * 创建时间
     */
    private Long craeteTime;
    /**
     * 场馆ID
     */
    private Integer venueId;

    /**
     * 场馆名称
     */
    private String venueName;
    /**
     * 所选路径类型
     */
    private String path;
    /**
     * 所选路径类型难度
     */
    private String level;
    /**
     * 路径地图URL
     */
    private String url;

    /**
     * 分享的动态ID
     */
    private Integer showId;
}
