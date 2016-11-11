package com.zyx.param.venue;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/10
 */
public class FindVenueParam implements Serializable {

    /**
     * 查询方式(1、全部，2、距离当前经纬度最近，3、最热门， 4、最大难度)
     */
    private Integer type;

    /**
     * 当前用户的经度
     */
    private Double lng;

    /**
     * 当前用户的纬度
     */
    private Double lat;

    /**
     * 每页显示条数
     */
    private Integer number;

    /**
     * 当前第几页
     */
    private Integer pageNumber;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
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
