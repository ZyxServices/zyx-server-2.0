package com.zyx.mapper.venue;

import java.util.List;
import com.zyx.entity.venue.Venue;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.venue.VenueParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by MrDeng on 2016/11/7.
 */
@Repository("venueMapper")
public interface VenueMapper extends BaseMapper<Venue> {
    public List<Venue> selectVenues(VenueParam param);

    /**
     * 获取用户足迹对应场馆信息
     * @param userId
     * @return
     */
    public List<Venue> selectUserFpVenus(@Param("userId") Integer userId);

    public Integer countUserFpCity(@Param("userId")Integer userId);
}
