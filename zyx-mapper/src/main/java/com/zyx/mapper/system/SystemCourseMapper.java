package com.zyx.mapper.system;

import com.zyx.entity.system.CourseLabel;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.system.CourseParam;
import com.zyx.vo.system.CourseLabelVo;
import com.zyx.vo.system.CourseVo;
import org.springframework.stereotype.Repository;

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
@Repository("systemCourseMapper")
public interface SystemCourseMapper extends BaseMapper<CourseLabel> {

    /**
     * 查询教程筛选标签
     *
     * @return
     */
    List<CourseLabelVo> findCourseLabel();

    /**
     * 查询教程列表
     *
     * @return
     */
    List<CourseVo> findCourseList(CourseParam param);

    /**
     * 通过教程ID 查询教程详细信息
     *
     * @return
     */
    CourseVo findCourseById(Integer courseId);
}
