package com.zyx.service.system.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.mapper.system.SystemCourseMapper;
import com.zyx.param.attention.AttentionParam;
import com.zyx.param.system.CourseParam;
import com.zyx.service.attention.UserAttentionService;
import com.zyx.service.system.SystemCourseService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.system.CourseLabelVo;
import com.zyx.vo.system.CourseVo;
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
 * @since 2016/11/14
 */
@Service
public class SystemCourseServiceImpl implements SystemCourseService {

    @Resource
    private SystemCourseMapper systemCourseMapper;
    @Resource
    private UserAttentionService userAttentionService;

    @Override
    public Map<String, Object> findCourseLabel() {
        List<CourseLabelVo> labelVos = systemCourseMapper.findCourseLabel();
        return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, labelVos);
    }

    @Override
    public Map<String, Object> findCourseList(CourseParam param) {
        if (param.getPageNumber() != null && param.getNumber() != null) {
            if (param.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            param.setPageNumber((param.getPageNumber() - 1) * param.getNumber());
            List<CourseVo> courseList = systemCourseMapper.findCourseList(param);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, courseList);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> findCourseById(Integer userId, Integer courseId) {
        if (courseId != null && courseId > 0) {
            CourseVo courseVo = systemCourseMapper.findCourseById(courseId);
            if(courseVo != null){
                if (userId != null) {
                    AttentionParam param = new AttentionParam();
                    param.setFromId(userId);
                    param.setToId(courseVo.getUserId());
                    param.setType(1);
                    int i = userAttentionService.selectAttentionCount(param);
                    if (i > 0) {
                        courseVo.setIsconcern(true);
                    } else {
                        courseVo.setIsconcern(false);
                    }
                } else {
                    courseVo.setIsconcern(false);
                }
            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, courseVo);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }
}
