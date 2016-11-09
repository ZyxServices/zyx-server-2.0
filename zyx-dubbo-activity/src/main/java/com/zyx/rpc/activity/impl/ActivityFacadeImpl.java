package com.zyx.rpc.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.param.activity.ActivityParam;
import com.zyx.param.activity.MyActivityListParam;
import com.zyx.param.activity.QueryActivityParam;
import com.zyx.rpc.activity.ActivityFacade;
import com.zyx.service.activity.ActivityService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.rpc.activity.impl
 */
@Service("activityFacade")
public class ActivityFacadeImpl implements ActivityFacade {

    @Resource
    private ActivityService activityService;

    private static Logger logger = Logger.getLogger(ActivityFacadeImpl.class);

    @Override
    public Map<String, Object> insertActivity(ActivityParam activityParam) {
        try {
            return activityService.insterActivity(activityParam);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryActivity(QueryActivityParam queryParam) {
        try {
            return activityService.queryActivity(queryParam);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myActivityList(MyActivityListParam listParam) {
        try {
            return activityService.myActivityList(listParam);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> activityById(Integer activityId) {
        try {
            return activityService.activityById(activityId);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }
}
