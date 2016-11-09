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
    public void uploadSportRecord(Integer userId, Integer type, Integer sportInfoId, Long spendTime) {
        SportRecord entity = new SportRecord();
        entity.setUserId(userId);
        entity.setType(type);
        entity.setSportInfoId(sportInfoId);
        entity.setSpendTime(spendTime);
        entity.setCreateTime(System.currentTimeMillis());
        sportRecordService.save(entity);
    }

    @Override
    public List<SportRecordVo> getHistoryRecords(SportRecordParam param) {
        return sportRecordService.getHistoryRecords(param);
    }

    @Override
    public RankVo getSelfRank(Integer userId) {
        return null;
    }

    @Override
    public List<RankVo> getRanks(RankParam param) {
        return null;
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

    @Override
    public List<Venue> getVenues(VenueParam param) {
        return venueService.getVenues(param);
    }

    @Override
    public SportOverviewVo getSelfRecordOverview(Integer userId) {
        return sportRecordService.getRecordOverview(userId);
    }
}
