package com.zyx.service.activity;

import com.zyx.param.activity.ActivityParam;
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
}
