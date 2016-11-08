package com.zyx.vo.record;

import com.zyx.entity.record.Footprint;
import com.zyx.entity.venue.Venue;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/8.
 * 足迹场馆的详细信息
 */
public class FootprintVenueVo {

    private Integer cityCount;
    private Integer fpCount;
    List<Venue> venues;

    public Integer getCityCount() {
        return cityCount;
    }

    public void setCityCount(Integer cityCount) {
        this.cityCount = cityCount;
    }

    public Integer getFpCount() {
        return fpCount;
    }

    public void setFpCount(Integer fpCount) {
        this.fpCount = fpCount;
    }

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }
}
