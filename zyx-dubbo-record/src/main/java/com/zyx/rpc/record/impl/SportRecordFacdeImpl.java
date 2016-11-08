package com.zyx.rpc.record.impl;

import com.zyx.entity.record.Footprint;
import com.zyx.entity.record.SportRecord;
import com.zyx.entity.venue.SportInfo;
import com.zyx.entity.venue.Venue;
import com.zyx.param.Pager;
import com.zyx.param.record.RankParam;
import com.zyx.param.record.SportRecordParam;
import com.zyx.param.venue.VenueParam;
import com.zyx.rpc.record.SportRecordFacade;
import com.zyx.service.record.FootprintService;
import com.zyx.service.record.SportRecordService;
import com.zyx.service.venue.SportInfoService;
import com.zyx.service.venue.VenueService;
import com.zyx.vo.record.FootprintVenueVo;
import com.zyx.vo.record.RankVo;
import com.zyx.vo.record.SportOverviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/4.
 */
@Service("sportRecordFacade")
public class SportRecordFacdeImpl implements SportRecordFacade {

    @Autowired
    FootprintService footprintService;
    @Autowired
    SportRecordService sportRecordService;
    @Autowired
    SportInfoService sportInfoService;
    @Autowired
    VenueService venueService;

    @Override
    public void uploadFootprint(Integer userId, Integer venueId) {
        Footprint entity = new Footprint();
        entity.setUserId(userId);
        entity.setVenueId(venueId);
        entity.setCreateTime(System.currentTimeMillis());
        footprintService.save(entity);
    }

    @Override
    public FootprintVenueVo getFootprints(Integer userId, Pager pager) {
        FootprintVenueVo vo = new FootprintVenueVo();
        Footprint record = new Footprint();
        record.setUserId(userId);
        Integer fpCount = footprintService.selectCount(record);
        if (fpCount != null && fpCount > 0) {
            vo.setFpCount(fpCount);
            Integer citiyCont = venueService.countUserFpCity(userId);
            if (citiyCont != null && citiyCont > 0){
                vo.setCityCount(citiyCont);
                vo.setVenues(venueService.getUserFpVenus(userId));
            }
        }
        return vo;
    }

    @Override
    public void uploadSportRecord(Integer userId, Integer type, Integer sportInfoId, Long spendTime) {
        SportRecord entity = new SportRecord();
        entity.setUserId(userId);
        entity.setType(type);
        entity.setSportIfonId(sportInfoId);
        entity.setSpendTime(spendTime);
        entity.setCreateTime(System.currentTimeMillis());
        sportRecordService.save(entity);
    }

    @Override
    public List<SportRecord> getSportRecords(SportRecordParam param) {
//        sportRecordService.s
        return null;
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
    public SportOverviewVo getSelfRecord(Integer userId) {
        return sportRecordService.getTimesScore(userId);
    }
}
