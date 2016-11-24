package com.zyx.vo.activity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/9
 */
public class MemberActivityVo implements Serializable {

    private Integer id;
    /**
     * 活动ID
     */
    private ActivityListVo activity;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 报名时间
     */
    private Long joinTime;

    /**
     * 创建时间
     */
    private Long createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ActivityListVo getActivity() {
        return activity;
    }

    public void setActivity(ActivityListVo activity) {
        this.activity = activity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Long joinTime) {
        this.joinTime = joinTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
