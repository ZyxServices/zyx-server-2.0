package com.zyx.service.system.impl;

import com.zyx.constants.Constants;
import com.zyx.mapper.system.SystemCourseMapper;
import com.zyx.param.system.CourseParam;
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

    @Override
    public Map<String, Object> findCourseLabel() {
        List<CourseLabelVo> labelVos = systemCourseMapper.findCourseLabel();
        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", labelVos);
    }

    @Override
    public Map<String, Object> findCourseList(CourseParam param) {
        if (param.getPageNumber() != null && param.getNumber() != null) {
            param.setPageNumber((param.getPageNumber() - 1) * param.getNumber());
            List<CourseVo> courseList = systemCourseMapper.findCourseList(param);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", courseList);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> findCourseById(Integer courseId) {
        if (courseId != null && courseId > 0) {
            CourseVo courseVo = systemCourseMapper.findCourseById(courseId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", courseVo);
        }else{
            return Constants.MAP_PARAM_MISS;
        }
    }
}
