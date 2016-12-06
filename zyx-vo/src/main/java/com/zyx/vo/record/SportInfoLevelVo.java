package com.zyx.vo.record;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/12/6.
 */
public class SportInfoLevelVo implements Serializable {
    private Integer id;
    private String level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
