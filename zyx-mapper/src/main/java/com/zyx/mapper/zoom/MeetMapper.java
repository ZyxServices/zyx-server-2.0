package com.zyx.mapper.zoom;

import com.zyx.entity.zoom.Meet;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.zoom
 * Create by XiaoWei on 2016/6/14
 */
@Repository("meetMapper")
public interface MeetMapper extends BaseMapper<Meet> {
    Integer existTodayMeet(@Param("accountId") Integer accountId, @Param("circleId") Integer circleId, @Param("startTime") Long startTime, @Param("endTime") Long endTime);
}
