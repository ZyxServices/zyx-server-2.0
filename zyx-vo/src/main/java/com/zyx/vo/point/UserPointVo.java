package com.zyx.vo.point;

import java.io.Serializable;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
public class UserPointVo implements Serializable {
    private static final long serialVersionUID = 3537211022312671716L;

    private Integer id;

    private Integer userId;

//    private Long modifyTime;
//
//    private Long createTime;
//
//    private Integer pointType;

    private Long pointCount;

    private String pointDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getPointCount() {
        return pointCount;
    }

    public void setPointCount(Long pointCount) {
        this.pointCount = pointCount;
    }

    public String getPointDesc() {
        return pointDesc;
    }

    public void setPointDesc(String pointDesc) {
        this.pointDesc = pointDesc;
    }
}
