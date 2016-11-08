package com.zyx.service.venue;

import java.util.List;
import com.zyx.entity.venue.Venue;
import com.zyx.param.venue.VenueParam;
import com.zyx.service.BaseService;

/**
 * Created by MrDeng on 2016/11/7.
 */
public interface VenueService extends BaseService<Venue> {

    /**
     * 根据半径查询 半径范围内的场馆信息
     * 实际处理为 radius 宽度的正方形范围
     * @param param
     * @return
     */
    public List<Venue> getVenues(VenueParam param);

    /**
     * 获取用户足迹对应的场馆信息
     * @param userId
     * @return
     */
    public List<Venue> getUserFpVenus(Integer userId);

    /**
     * 统计用户足迹所到场馆数量
     * @param userId
     * @return
     */
    public Integer countUserFpCity(Integer userId);
}
