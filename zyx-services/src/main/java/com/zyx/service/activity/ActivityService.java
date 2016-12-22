package com.zyx.service.activity;

import com.zyx.param.activity.ActivityParam;
import com.zyx.param.activity.MyActivityListParam;
import com.zyx.param.activity.QueryActivityParam;

import java.util.Map;

/**
 * Created by Rainbow on 2016/11/3.
 */
public interface ActivityService {

    /**
     * 创建活动
     * @param param
     * @return
     */
    Map<String, Object> insterActivity(ActivityParam param);

    /**
     * 查询活动
     * @param queryParam
     * @return
     */
    Map<String, Object> queryActivity(QueryActivityParam queryParam);

    /**
     * 通过用户ID 查询活动
     * @param myActivityListParam
     * @return
     */
    Map<String, Object> myActivityList(MyActivityListParam myActivityListParam);

    /**
     * 通过ID查询活动详细信息
     * @param activityId
     * @return
     */
    Map<String, Object> activityById(Integer activityId, Integer userId);

    /**
     * 通过ID删除活动
     *
     * @param activityId
     * @return
     */
    Map<String, Object> delActivityById(Integer activityId, Integer userId);
}
