package com.zyx.mapper.system;

import com.zyx.entity.system.Course;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.system.SearchParam;
import com.zyx.vo.system.SearchActivityVo;
import com.zyx.vo.system.SearchConcernVo;
import com.zyx.vo.system.SearchCourseVo;
import com.zyx.vo.system.SearchVenuesVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/9
 */
@Repository("searchMapper")
public interface SearchMapper extends BaseMapper<Course> {

    /**
     * 查询活动模块
     * @param searchParam
     * @return
     */
    List<SearchActivityVo> searchActivity(SearchParam searchParam);

    /**
     * 查询场馆模块
     * @param searchParam
     * @return
     */
    List<SearchVenuesVo> searchVenues(SearchParam searchParam);

    /**
     * 查询教程模块
     * @param searchParam
     * @return
     */
    List<SearchCourseVo> searchCourse(SearchParam searchParam);

    /**
     * 查询动态模块
     * @param searchParam
     * @return
     */
    List<SearchConcernVo> searchConcern(SearchParam searchParam);
}