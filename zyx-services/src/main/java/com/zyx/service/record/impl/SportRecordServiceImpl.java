package com.zyx.service.record.impl;

import com.alibaba.fastjson.JSON;
import com.zyx.entity.record.SportRecord;
import com.zyx.mapper.record.SportRecordMapper;
import com.zyx.param.record.RankParam;
import com.zyx.param.record.SportRecordParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.record.SportRecordService;
import com.zyx.vo.record.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/4.
 */
@Service("sportRecordService")
public class SportRecordServiceImpl extends BaseServiceImpl<SportRecord> implements SportRecordService{

    @Autowired
    SportRecordMapper sportRecordMapper;
    public SportRecordServiceImpl() {
        super(SportRecord.class);
    }

    @Override
    public SportOverviewVo getRecordOverview(Integer userId) {
        return sportRecordMapper.selectRecordOverview(userId);
    }

    @Override
    public List<SportRecordVo> getHistoryRecords(SportRecordParam param) {
        return sportRecordMapper.selectHistoryRecords(param);
    }

    @Override
    public List<CityFootprintVo> getCityFootprints(Integer userId) {
        return sportRecordMapper.selectCityFootprints(userId);
    }

    @Override
    public List<FootprintVo> getVenueFootprints(Integer userId, String city) {
        return sportRecordMapper.selectVenueFootprints(userId,city);
    }

    @Override
    public List<RankVo> getRankList(RankParam param) {
        return sportRecordMapper.selectRankList(param);
    }

    @Override
    public RankVo getSelfRank(RankParam param) {
        return sportRecordMapper.selectSelfRank(param);
    }
}
