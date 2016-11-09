package com.zyx.service.record.impl;

import com.alibaba.fastjson.JSON;
import com.zyx.entity.record.SportRecord;
import com.zyx.mapper.record.SportRecordMapper;
import com.zyx.param.record.SportRecordParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.record.SportRecordService;
import com.zyx.vo.record.CityFootprintVo;
import com.zyx.vo.record.FootprintVo;
import com.zyx.vo.record.SportOverviewVo;
import com.zyx.vo.record.SportRecordVo;
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
}
