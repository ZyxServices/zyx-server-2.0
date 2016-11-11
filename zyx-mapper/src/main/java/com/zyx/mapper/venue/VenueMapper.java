package com.zyx.mapper.venue;

import com.zyx.entity.venue.Venue;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.venue.FindVenueParam;
import com.zyx.param.venue.VenueParam;
import com.zyx.vo.venue.FindVenueVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/7.
 */
@Repository("venueMapper")
public interface VenueMapper extends BaseMapper<Venue> {
    public List<Venue> selectVenues(VenueParam param);

    /**
     * 场馆查询
     *
     * @param param
     * @return
     */
    List<FindVenueVo> findVenues(FindVenueParam param);

    /**
     * 场馆详细信息查询
     *
     * @param id
     * @return
     */
    FindVenueVo findVenueById(Integer id);

    /**
     * 获取用户足迹对应场馆信息
     * @param userId
     * @return
     */
//    public List<Venue> selectUserFpVenus(@Param("userId") Integer userId);
//
//    public Integer countUserFpCity(@Param("userId")Integer userId);
}
