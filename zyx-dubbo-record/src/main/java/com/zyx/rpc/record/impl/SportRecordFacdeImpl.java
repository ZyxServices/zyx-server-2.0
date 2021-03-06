package com.zyx.rpc.record.impl;

import com.zyx.entity.record.SportRecord;
import com.zyx.entity.venue.SportInfo;
import com.zyx.entity.venue.Venue;
import com.zyx.param.record.RankParam;
import com.zyx.param.record.SportRecordParam;
import com.zyx.param.venue.VenueParam;
import com.zyx.rpc.record.SportRecordFacade;
import com.zyx.service.record.SportRecordService;
import com.zyx.service.venue.SportInfoService;
import com.zyx.service.venue.VenueService;
import com.zyx.vo.account.UserIconVo;
import com.zyx.vo.record.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/4.
 */
@Service("sportRecordFacade")
public class SportRecordFacdeImpl implements SportRecordFacade {

    @Autowired
    SportRecordService sportRecordService;
    @Autowired
    SportInfoService sportInfoService;
    @Autowired
    VenueService venueService;


    @Override
    public List<CityFootprintVo> getCityFootprints(Integer userId) {
        return sportRecordService.getCityFootprints(userId);
    }

    @Override
    public List<FootprintVo> getVenueFootprints(Integer userId, String city) {
        return sportRecordService.getVenueFootprints(userId,city);
    }

    @Override
    public SportRecord uploadSportRecord(Integer userId, Integer type,Integer venueId, String level,Integer score, Long spendTime) {
        SportRecord entity = new SportRecord();
        entity.setUserId(userId);
        entity.setType(type);
        entity.setVenueId(venueId);
        entity.setLevel(level);
        entity.setScore(score);
        entity.setSpendTime(spendTime);
        entity.setCreateTime(System.currentTimeMillis());
        sportRecordService.save(entity);
        return entity;
    }

    @Override
    public List<SportRecordVo> getHistoryRecords(SportRecordParam param) {
        return sportRecordService.getHistoryRecords(param);
    }

    @Override
    public RankVo getSelfRank(RankParam param) {
        return sportRecordService.getSelfRank(param);
    }

    @Override
    public List<RankVo> getRanks(RankParam param) {
        return sportRecordService.getRankList(param);
    }

    @Override
    public Integer showToCircleItem(Integer userId, Integer recordId) {
        return null;
    }

    @Override
    public List<SportInfo> getSportInfos(Integer venueId) {
        return null;
    }

    @Override
    public void uploadPathLevel(Integer venueId, String level) {
        SportInfo entity = new SportInfo();
        entity.setVenueId(venueId);
        entity.setLevel(level);
        sportInfoService.save(entity);
    }

//    @Override
//    public List<Venue> getVenues(VenueParam param) {
//        return venueService.getVenues(param);
//    }

    @Override
    public SportOverviewVo getSelfRecordOverview(Integer userId) {
        return sportRecordService.getRecordOverview(userId);
    }

    @Override
    public List<SportInfoLevelVo> getSportInfoLevel(Integer venueId) {
        return sportRecordService.getSportInfoLevel(venueId);
    }

    @Override
    public List<UserIconVo> getRecordUserIcon(Integer venueId, Integer pageSize, Integer pageNum) {
        SportRecordParam param = new SportRecordParam();
        param.setVenueId(venueId);
        param.setPageNum(pageNum);
        param.setPageSize(pageSize);
        return sportRecordService.getRecordUserIcon(param );
    }
}
