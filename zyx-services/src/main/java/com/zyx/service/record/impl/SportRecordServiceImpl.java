package com.zyx.service.record.impl;

import com.zyx.entity.record.SportRecord;
import com.zyx.mapper.record.SportRecordMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.record.SportRecordService;
import com.zyx.vo.record.SportOverviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public SportOverviewVo getTimesScore(Integer userId) {
        return sportRecordMapper.selectTimesScore(userId);
    }
}
