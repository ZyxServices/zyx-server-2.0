package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.param.activity.ActivityParam;
import com.zyx.param.activity.MyActivityListParam;
import com.zyx.param.activity.QueryActivityParam;
import com.zyx.service.activity.ActivityService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.activity.ActivityVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Rainbow on 2016/11/3.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Override
    public Map<String, Object> insterActivity(ActivityParam param) {
        if (param.getUserId() != null && param.getTitle() != null && param.getDesc() != null && param.getImgUrls() != null
                && param.getStartTime() != null && param.getStartTime() != 0 && param.getEndTime() != null && param.getEndTime() != 0
                && param.getLastTime() != null && param.getLastTime() != 0 && param.getType() != null && param.getPrice() != null && param.getAddress() != null) {
            Activity activity = new Activity();

            activity.setUserId(param.getUserId());
            activity.setTitle(param.getTitle());
            activity.setActivityType(param.getType());
            activity.setImgUrls(param.getImgUrls());
            activity.setDescContent(param.getDesc());
            activity.setStartTime(param.getStartTime());
            activity.setEndTime(param.getEndTime());
            activity.setLastTime(param.getLastTime());
            activity.setAddress(param.getAddress());
            activity.setMaxPeople(param.getMaxPepople());
            activity.setPrice(param.getPrice());
            activity.setCreateTime(System.currentTimeMillis());
            activity.setDel(0);
            activity.setActivityModule(1);
            activity.setTargetUrl("");
            activity.setMask(0);

            Integer integer = activityMapper.insert(activity);
            if (integer > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "发布成功", null);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10000, "活动发布失败");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> queryActivity(QueryActivityParam queryParam) {
        if (queryParam.getActivityState() == null) queryParam.setActivityState(0);
        if (queryParam.getActivityType() == null) queryParam.setActivityType(0);
        if (queryParam.getPageNumber() != null && queryParam.getNumber() != null) {
            if (queryParam.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            queryParam.setPageNumber((queryParam.getPageNumber() - 1) * queryParam.getNumber());
            queryParam.setNowTime(System.currentTimeMillis());
            List<ActivityVo> activityVo = activityMapper.queryActivity(queryParam);
            if (activityVo.size() > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", activityVo);
            }else{
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查无数据", null);
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> myActivityList(MyActivityListParam listParam) {
        if(listParam.getUserId() != null && listParam.getNumber() == null && listParam.getPageNumber() != null){
            if (listParam.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            List<ActivityVo> myActivityList = activityMapper.myActivityList(listParam);
            if(myActivityList.size() > 0){
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", myActivityList);
            }else{
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查无数据", null);
            }
        }else{
            return Constants.MAP_PARAM_MISS;
        }
    }
}
