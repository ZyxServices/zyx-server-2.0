package com.zyx.entity.record;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * Created by MrDeng on 2016/11/4.
 * 记录某个用户某时到过某个场馆 足迹
 */
@Table(name = "t_footprint")
public class Footprint extends BaseEntity {
    private Integer userId;
    private Integer venueId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }
}
