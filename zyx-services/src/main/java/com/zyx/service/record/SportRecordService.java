package com.zyx.service.record;

import com.zyx.entity.record.SportRecord;
import com.zyx.param.record.RankParam;
import com.zyx.param.record.SportRecordParam;
import com.zyx.service.BaseService;
import com.zyx.vo.record.*;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/4.
 */
public interface SportRecordService extends BaseService<SportRecord> {

    public SportOverviewVo getRecordOverview(Integer userId);

    public List<SportRecordVo> getHistoryRecords(SportRecordParam param);

    List<CityFootprintVo> getCityFootprints(Integer userId);
    List<FootprintVo> getVenueFootprints(Integer userId, String city);

    List<RankVo> getRankList(RankParam param);

    RankVo getSelfRank(RankParam param);
}
