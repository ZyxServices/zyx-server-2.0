package com.zyx.vo.record;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/11/8.
 * 场馆足迹
 */
public class FootprintVo implements Serializable {
    private String city;
    private Integer venueId;
    private String venueName;
    private String address;

    private String fpNumber;

    private Double longitude;
    private Double latitude;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFpNumber() {
        return fpNumber;
    }

    public void setFpNumber(String fpNumber) {
        this.fpNumber = fpNumber;
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
}
