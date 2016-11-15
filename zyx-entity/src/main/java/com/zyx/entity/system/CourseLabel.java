package com.zyx.entity.system;

import com.zyx.entity.BaseEntity;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/14
 */
public class CourseLabel extends BaseEntity {

    /**
     * 教程攻略名称
     */
    private String labelName;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 开启状态
     */
    private Integer state;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
