package com.zyx.param.venue;

import com.zyx.param.BaseParam;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/11/7.
 */
public class VenueParam implements Serializable {
    public Double longitude;
    public Double latitude;
    public Double radius;

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

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
