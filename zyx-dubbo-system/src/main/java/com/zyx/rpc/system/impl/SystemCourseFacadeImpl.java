package com.zyx.rpc.system.impl;

import com.zyx.constants.Constants;
import com.zyx.param.system.CourseParam;
import com.zyx.rpc.system.SystemCourseFacade;
import com.zyx.service.system.SystemCourseService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/14
 */
@Service("systemCourseFacade")
public class SystemCourseFacadeImpl implements SystemCourseFacade {

    @Resource
    private SystemCourseService systemCourseService;

    private static Logger logger = Logger.getLogger(SystemCityFacadeimpl.class);

    @Override
    public Map<String, Object> findCourseLabel() {
        try {
            return systemCourseService.findCourseLabel();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> findCourseList(CourseParam param) {
        try {
            return systemCourseService.findCourseList(param);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> findCourseById(Integer courseId) {
        try {
            return systemCourseService.findCourseById(courseId);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }
}
