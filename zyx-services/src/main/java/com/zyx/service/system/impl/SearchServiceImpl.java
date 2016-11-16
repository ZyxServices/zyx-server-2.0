package com.zyx.service.system.impl;

import com.zyx.constants.Constants;
import com.zyx.mapper.system.SearchMapper;
import com.zyx.param.system.SearchParam;
import com.zyx.service.system.SearchService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.system.SearchActivityVo;
import com.zyx.vo.system.SearchConcernVo;
import com.zyx.vo.system.SearchCourseVo;
import com.zyx.vo.system.SearchVenuesVo;
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
public class SearchServiceImpl implements SearchService {

    @Resource
    private SearchMapper searchMapper;

    @Override
    public Map<String, Object> modularSearch(SearchParam searchParam) {
        if (searchParam != null && searchParam.getModel() != null && searchParam.getPageNumber() != null && searchParam.getNumber() != null) {
            if (searchParam.getCharacter() == null) searchParam.setCharacter("");
            searchParam.setPageNumber((searchParam.getPageNumber() - 1) * searchParam.getNumber());
            switch (searchParam.getModel()) {
                case 1: // 活动
                    List<SearchActivityVo> searchActivityVos = searchMapper.searchActivity(searchParam);
                    if (searchActivityVos.size() > 0) {
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchActivityVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
                case 2: //装备
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", "暂未开放次模块");
                case 3: //动态
                    List<SearchConcernVo> searchConcernVos = searchMapper.searchConcern(searchParam);
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchConcernVos);
                case 4: //场馆
                    List<SearchVenuesVo> searchVenuesVos = searchMapper.searchVenues(searchParam);
                    if (searchVenuesVos.size() > 0) {
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchVenuesVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
                case 5: //教程
                    List<SearchCourseVo> searchCourseVos = searchMapper.searchCourse(searchParam);
                    if (searchCourseVos.size() > 0) {
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchCourseVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
                case 6: //用户
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", "暂未开放次模块");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
    }
}
