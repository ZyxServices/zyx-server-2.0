package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.ActivityMember;
import com.zyx.mapper.activity.ActivityMemberMapper;
import com.zyx.param.activity.ActivityMemberParam;
import com.zyx.param.activity.QueryActivityMemberParam;
import com.zyx.service.activity.ActivityMemberService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.activity.ActivityVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class ActivityMemberServiceImpl implements ActivityMemberService {
    @Resource
    private ActivityMemberMapper activityMemberMapper;

    @Override
    public Map<String, Object> insertMember(ActivityMemberParam memberParam) {
        if (memberParam.getUserId() != null && memberParam.getActivityId() != null) {
            ActivityMember activityMember = new ActivityMember();
            activityMember.setUserId(memberParam.getUserId());
            activityMember.setActivityId(memberParam.getActivityId());
            activityMember.setJoinTime(System.currentTimeMillis());
            activityMember.setCreateTime(System.currentTimeMillis());
            int insert = activityMemberMapper.insert(activityMember);
            if (insert > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "报名成功", null);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10004, "报名失败");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> findMemberById(QueryActivityMemberParam memberParam) {
        if (memberParam.getActivityId() > 0 && memberParam.getPageNumber() != null && memberParam.getNumber() != null) {
            if (memberParam.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            memberParam.setPageNumber((memberParam.getPageNumber() - 1) * memberParam.getNumber());

            List<ActivityVo> activityVos = activityMemberMapper.findMemberById(memberParam);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", activityVos);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> findMemberByUserId(QueryActivityMemberParam memberParam) {
        if (memberParam.getUserId() != null && memberParam.getPageNumber() != null && memberParam.getNumber() != null) {
            if (memberParam.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            memberParam.setPageNumber((memberParam.getPageNumber() - 1) * memberParam.getNumber());

            List<ActivityVo> activityVos = activityMemberMapper.findMemberByUserId(memberParam);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", activityVos);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }
}
