package com.zyx.entity.point;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
@Table(name = "user_point")
public class UserPointInfo extends BaseEntity {

    private static final long serialVersionUID = 7305025307318095813L;

    private Integer userId;

    private Long modifyTime;

    private Integer pointType;

    private Long pointCount;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getPointType() {
        return pointType;
    }

    public void setPointType(Integer pointType) {
        this.pointType = pointType;
    }

    public Long getPointCount() {
        return pointCount;
    }

    public void setPointCount(Long pointCount) {
        this.pointCount = pointCount;
    }
}
