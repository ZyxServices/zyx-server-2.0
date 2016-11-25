package com.zyx.mapper.activity;

import com.zyx.entity.activity.Activity;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.activity.MyActivityListParam;
import com.zyx.param.activity.QueryActivityParam;
import com.zyx.vo.activity.ActivityListVo;
import com.zyx.vo.activity.ActivityVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/7
 */
@Repository("activityMapper")
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 多条件查询活动
     *
     * @param queryActivityParam
     * @return
     */
    List<ActivityListVo> queryActivity(QueryActivityParam queryActivityParam);

    /**
     * 通过用户ID 查询活动
     * @param myActivityListParam
     * @return
     */
    List<ActivityListVo> myActivityList(MyActivityListParam myActivityListParam);

    /**
     * 通过ID查询活动详细信息
     * @param activityId
     * @return
     */
    ActivityVo activityById(Integer activityId);
}
