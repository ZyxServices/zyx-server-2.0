package com.zyx.vo.venue;

import com.zyx.entity.venue.Venue;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/11
 */
public class FindVenueVo implements Serializable {
    private Integer id;
    /**
     * 场馆类型（1-室内 2-室外）
     */
    private Integer type;

    /**
     * 场馆名称
     */
    private String name;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 冗余标注所属城市便于展示
     */
    private String city;
    /**
     * 描述标签
     */
    private String mark;
    /**
     * 场馆介绍
     */
    private String description;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 场馆地址
     */
    private String address;
    /**
     * 场馆封面
     */
    private String imgUrls;
    /**
     * 场馆综合难度
     */
    private String level;
    /**
     * 创建时间
     */
    private Long create_time;

    /**
     * 距离当前位置多少米
     */
    private Long distance;

    /**
     * 到过场馆的人数
     */
    private Integer pnumber;

    /**
     * 回复数量
     */
    private Integer commentNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }
}
