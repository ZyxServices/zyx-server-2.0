package com.zyx.mapper.system;

import com.zyx.entity.system.Course;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.system.SearchDevaParam;
import com.zyx.param.system.SearchParam;
import com.zyx.vo.system.*;
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
     *
     * @param searchParam
     * @return
     */
    List<SearchActivityVo> searchActivity(SearchParam searchParam);

    /**
     * 查询场馆模块
     *
     * @param searchParam
     * @return
     */
    List<SearchVenuesVo> searchVenues(SearchParam searchParam);

    /**
     * 查询教程模块
     *
     * @param searchParam
     * @return
     */
    List<SearchCourseVo> searchCourse(SearchParam searchParam);

    /**
     * 查询动态模块
     *
     * @param searchParam
     * @return
     */
    List<SearchConcernVo> searchConcern(SearchParam searchParam);

    /**
     * 查询用户模块
     *
     * @param searchParam
     * @return
     */
    List<SearchUserVo> searchUser(SearchParam searchParam);

    /**
     * 查询装备模块
     *
     * @param searchParam
     * @return
     */
    List<SearchEquipVo> equipSearch(SearchParam searchParam);

    /**
     * 官方推荐查询
     *
     * @return
     */
    List<SearchDevaVo> devaSearch(SearchDevaParam searchDevaParam);


}
