package com.zyx.mapper.record;

import com.zyx.entity.record.SportRecord;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.record.SportRecordParam;
import com.zyx.vo.record.CityFootprintVo;
import com.zyx.vo.record.FootprintVo;
import com.zyx.vo.record.SportOverviewVo;
import com.zyx.vo.record.SportRecordVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/4.
 */
@Repository("sportRecordMapper")
public interface SportRecordMapper extends BaseMapper<SportRecord> {

    public SportOverviewVo selectRecordOverview(@Param("userId") Integer userId);

    List<SportRecordVo> selectHistoryRecords(SportRecordParam param);

    /**
     * 查询某个用户全国所有城市的足迹概况
     * @param userId
     * @return
     */
    List<CityFootprintVo> selectCityFootprints(@Param("userId") Integer userId);

    /**
     * 查询某个用户某个城市的足迹
     * @param userId
     * @param city
     * @return
     */
    List<FootprintVo> selectVenueFootprints(@Param("userId") Integer userId, @Param("city") String city);
}
