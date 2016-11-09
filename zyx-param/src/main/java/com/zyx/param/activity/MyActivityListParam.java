package com.zyx.param.activity;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/9
 */
public class MyActivityListParam implements Serializable {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 美也显示多少条
     */
    private Integer number;

    /**
     * 当前第几页
     */
    private Integer pageNumber;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
