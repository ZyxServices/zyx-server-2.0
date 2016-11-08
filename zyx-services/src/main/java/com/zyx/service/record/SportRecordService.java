package com.zyx.service.record;

import com.zyx.entity.record.SportRecord;
import com.zyx.service.BaseService;
import com.zyx.vo.record.SportOverviewVo;

/**
 * Created by MrDeng on 2016/11/4.
 */
public interface SportRecordService extends BaseService<SportRecord> {

    public SportOverviewVo getTimesScore(Integer userId);
}
