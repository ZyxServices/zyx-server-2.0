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

import java.util.ArrayList;
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
        if(param.getPageSize()<1||param.getPageNum()<1)
            return new ArrayList<>();
        return sportRecordMapper.selectHistoryRecords(param);
    }

    @Override
    public List<CityFootprintVo> getCityFootprints(Integer userId) {
        List<FootprintVo> list = sportRecordMapper.selectFullCityFootprints(userId);
        if(list==null||list.isEmpty())
            return  null;
        List cityfts = new ArrayList<>();
        CityFootprintVo tmpVo=null;
        for (FootprintVo vo:list){
            if(tmpVo==null||!tmpVo.getCity().equals(vo.getCity())){
                tmpVo = new CityFootprintVo();
                tmpVo.setCity(vo.getCity());
                tmpVo.setFootprints(new ArrayList<FootprintVo>());
                cityfts.add(tmpVo);
            }
            tmpVo.setFpNumber(tmpVo.getFpNumber()==null?vo.getFpNumber():(vo.getFpNumber()+tmpVo.getFpNumber()));
            tmpVo.getFootprints().add(vo);
        }
        return cityfts;
    }

    @Override
    public List<FootprintVo> getVenueFootprints(Integer userId, String city) {
        return sportRecordMapper.selectVenueFootprints(userId,city);
    }

    @Override
    public List<RankVo> getRankList(RankParam param) {
        if(param.getPageSize()<1||param.getPageNum()<1)
            return new ArrayList<>();
        return sportRecordMapper.selectRankList(param);
    }

    @Override
    public RankVo getSelfRank(RankParam param) {
        return sportRecordMapper.selectSelfRank(param);
    }
}
