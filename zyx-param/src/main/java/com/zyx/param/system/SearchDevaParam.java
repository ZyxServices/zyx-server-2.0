package com.zyx.param.system;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/17
 */
public class SearchDevaParam implements Serializable {

    /**
     * 推荐模块 （1、首页，2、活动）
      */
    private Integer model;

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

}
