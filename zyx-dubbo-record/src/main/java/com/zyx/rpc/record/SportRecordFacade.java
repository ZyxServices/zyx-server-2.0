package com.zyx.rpc.record;

import com.zyx.entity.record.SportRecord;
import com.zyx.entity.venue.SportInfo;
import com.zyx.entity.venue.Venue;
import com.zyx.param.Pager;
import com.zyx.param.record.RankParam;
import com.zyx.param.record.SportRecordParam;
import com.zyx.param.venue.VenueParam;
import com.zyx.vo.record.FootprintVenueVo;
import com.zyx.vo.record.RankVo;
import com.zyx.vo.record.SportOverviewVo;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/4.
 */
public interface SportRecordFacade {


    /**
     * 上传用户足迹
     * @param userId
     * @param venueId
     */
    public void uploadFootprint(Integer userId, Integer venueId);

    /**
     * 获取用户的足迹信息
     * @param userId
     * @param pager
     * @return
     */
    public FootprintVenueVo getFootprints(Integer userId, Pager pager);

    /**
     * 上传用户运动记录
     *
     * @param userId
     * @param type
     * @param sportInfoId
     * @param spendTime
     */
    public void uploadSportRecord(Integer userId, Integer type, Integer sportInfoId, Long spendTime);


    /**
     * 查询用户的运动记录
     * @param param
     * @return
     */
    public List<SportRecord> getSportRecords(SportRecordParam param);


    /**
     * 获取自身的排名信息
     * @param userId
     * @return
     */
    public RankVo getSelfRank(Integer userId);

    /**
     * 获取排行榜信息
     * @param param
     * @return
     */
    public List<RankVo> getRanks(RankParam param);
    /**
     * 秀到动态
     *
     * @param userId
     * @param recordId
     * @return
     */
    public Integer showToCircleItem(Integer userId, Integer recordId);

    /**
     * 获取某个场馆下的所有运动难度
     * @param venueId
     * @return
     */
    public List<SportInfo> getSportInfos(Integer venueId);

    //Todo 测试暂用 正式版本删除

    /**
     * 上传场馆难度等级
     * @param venueId
     * @param level
     */
    public void uploadPathLevel(Integer venueId,String level);

    /**
     * 获取场馆信息
     * @param param
     * @return
     */
    public List<Venue> getVenues(VenueParam param);

    /**
     * 获取用户各人运动概况
     * 
     * @param userId
     * @return
     */
    // TODO: 2016/11/8 后期考虑另建表存储
    public SportOverviewVo getSelfRecord(Integer userId);

}
