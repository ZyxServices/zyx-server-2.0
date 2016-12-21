package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.entity.zoom.Concern;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.mapper.zoom.ConcernMapper;
import com.zyx.param.activity.ActivityParam;
import com.zyx.param.activity.MyActivityListParam;
import com.zyx.param.activity.QueryActivityParam;
import com.zyx.service.activity.ActivityService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.activity.ActivityListVo;
import com.zyx.vo.activity.ActivityVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/9
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private ConcernMapper concernMapper;

    @Override
    public Map<String, Object> insterActivity(ActivityParam param) {
        if (param.getUserId() != null && param.getTitle() != null && param.getDesc() != null && param.getImgUrls() != null && param.getPaymentType() != null
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
            activity.setMaxPeople(param.getMaxPepople() == null ? 0 : param.getMaxPepople());
            activity.setPrice(param.getPrice());
            activity.setPaymentType(param.getPaymentType());
            activity.setCreateTime(System.currentTimeMillis());
            activity.setCity(param.getCity());
            activity.setDel(0);
            activity.setActivityModule(1);
            activity.setTargetUrl("");
            activity.setMask(0);
            activity.setType(1);

            Integer integer = activityMapper.insert(activity);
            if (integer > 0) {
                Concern concern = new Concern();
                concern.setFromId(activity.getId());
                concern.setFromType(1);
                concern.setCreateTime(System.currentTimeMillis());
                concern.setImgUrl(param.getImgUrls());
                concern.setTopicTitle(param.getTitle());
                concern.setTopicContent(param.getDesc());
                concern.setTopicVisible(1);
                concern.setUserId(param.getUserId());
                concern.setState(0);
                concernMapper.insert(concern);
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
            List<ActivityListVo> activityVo = activityMapper.queryActivity(queryParam);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, activityVo);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> myActivityList(MyActivityListParam listParam) {
        if (listParam.getUserId() != null && listParam.getNumber() != null && listParam.getPageNumber() != null) {
            if (listParam.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            listParam.setPageNumber((listParam.getPageNumber() - 1) * listParam.getNumber());
            List<ActivityListVo> myActivityList = activityMapper.myActivityList(listParam);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, myActivityList);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> activityById(Integer activityId, Integer userId) {
        if (activityId != null && activityId > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("activityId", activityId);
            map.put("userId", userId);
            ActivityVo activityVo = activityMapper.activityById(map);
            //TODO 修改查询预留
            if (false) {
                String[] strings = activityVo.getDescContent().split("<img");
                List<String> editImage = new ArrayList<>();
                String editText = "";
                for (String string : strings) {
                    if (string.contains("src=")) {
                        editImage.add(string.substring(string.indexOf("src=\"") + 5, string.indexOf("\"/")));
                    } else {
                        if (editText.equals(string)) {
                            editText = string;
                        } else {
                            editText += string;
                        }

                    }
                }
                activityVo.setEditDescImgUrl(editImage);
                activityVo.setDescContent(editText);

            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, activityVo);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> delActivityById(Integer activityId, Integer userId) {
        if (activityId != null && userId != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("activityId", activityId);
            map.put("userId", userId);
            int delActivityById = activityMapper.delActivityById(map);
            activityMapper.delConcern(map);
            if (delActivityById > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, "删除成功");
            } else {
                return MapUtils.buildSuccessMap(ActivityConstants.AUTH_ERROR_10011, Constants.MSG_ERROR, "删除失败");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }
}
