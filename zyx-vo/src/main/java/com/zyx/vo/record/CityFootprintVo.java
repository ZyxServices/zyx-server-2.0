package com.zyx.vo.record;

import java.util.List;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/11/9.
 */
public class CityFootprintVo implements Serializable {
    private String city;
    private Integer fpNumber;
    private Integer imgUrls;

    private List<FootprintVo> footprints;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getFpNumber() {
        return fpNumber;
    }

    public void setFpNumber(Integer fpNumber) {
        this.fpNumber = fpNumber;
    }

    public List<FootprintVo> getFootprints() {
        return footprints;
    }

    public void setFootprints(List<FootprintVo> footprints) {
        this.footprints = footprints;
    }

    public Integer getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(Integer imgUrls) {
        this.imgUrls = imgUrls;
    }
}
