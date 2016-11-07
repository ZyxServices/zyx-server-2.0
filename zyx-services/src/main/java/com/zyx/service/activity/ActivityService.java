package com.zyx.service.activity;

import com.zyx.param.activity.ActivityParam;

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
}
