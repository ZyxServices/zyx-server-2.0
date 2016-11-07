package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.param.activity.ActivityParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityService;
import com.zyx.utils.MapUtils;

import java.util.Map;

/**
 * Created by Rainbow on 2016/11/3.
 */
public class ActivityServiceImpl extends BaseServiceImpl<Activity> implements ActivityService {
    public ActivityServiceImpl() {
        super(Activity.class);
    }

    @Override
    public Map<String, Object> insterActivity(ActivityParam param) {
        if (param.getUserId() != null && param.getTitle() != null && param.getDesc() != null && param.getImgUrls() != null
                && param.getStartTime() != null && param.getEndTime() != null
                && param.getType() != null && param.getPrice() != null && param.getAddress() != null){
            Activity activity = new Activity();

            activity.setUserId(param.getUserId());
            activity.setTitle(param.getTitle());
            activity.setDescContent(param.getDesc());
            activity.setStartTime(param.getStartTime());
            activity.setEndTime(param.getEndTime());
            activity.setLastTime(param.getLastTime());
            activity.setAddress(param.getAddress());
            activity.setMaxPeople(param.getMaxPepople());
            activity.setPrice(param.getPrice());
            activity.setMask(0);

            Integer integer = mapper.insert(activity);
            if (integer > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "发布成功", null);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10000, "活动发布失败");
            }
        } else{
            return Constants.MAP_PARAM_MISS;
        }

    }
}
