package com.zyx.param.record;

        import com.zyx.param.Pager;

/**
 * Created by MrDeng on 2016/11/4.
 */
public class SportRecordParam extends Pager {

    private Integer userId;

    private Integer venueId;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }
}
