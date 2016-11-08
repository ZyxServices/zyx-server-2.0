package com.zyx.mapper.record;

import com.zyx.entity.record.SportRecord;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.record.SportOverviewVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by MrDeng on 2016/11/4.
 */
@Repository("sportRecordMapper")
public interface SportRecordMapper extends BaseMapper<SportRecord> {

    public SportOverviewVo selectTimesScore(@Param("userId") Integer userId);
}
