package com.zyx.vo.record;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/11/9.
 */
public class CityFootprintVo implements Serializable {
    private String city;
    private Integer fpNumber;

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
}
