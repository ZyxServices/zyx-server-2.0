package com.zyx.mapper.venue;

import com.zyx.entity.venue.SportInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.record.SportInfoLevelVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/4.
 */
@Repository("sportInfoMapper")
public interface SportInfoMapper extends BaseMapper<SportInfo> {
    List<SportInfoLevelVo> selectSportInfoLevel(@Param("venueId")Integer venueId);
}
