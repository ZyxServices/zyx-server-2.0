package com.zyx.param.system;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/9
 */
public class SearchParam implements Serializable {

    /**
     * 查询关键字
     */
    private String character;
    /**
     * 每页显示多少条
     */
    private Integer number;
    /**
     * 当前第几页
     */
    private Integer pageNumber;
    /**
     * 查询类别
     */
    private Integer model;

    /**
     * 当前登录用户ID
     */
    private Integer userId;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
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

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
