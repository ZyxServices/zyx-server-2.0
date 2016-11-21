package com.zyx.service.system.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.mapper.system.SearchMapper;
import com.zyx.param.system.SearchDevaParam;
import com.zyx.param.system.SearchParam;
import com.zyx.service.system.SearchService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.system.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
            if (searchParam.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            searchParam.setPageNumber((searchParam.getPageNumber() - 1) * searchParam.getNumber());
            switch (searchParam.getModel()) {
                case 1: // 活动
                    List<SearchActivityVo> searchActivityVos = searchMapper.searchActivity(searchParam);
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, searchActivityVos);
                case 2: //装备
                    List<SearchEquipVo> equipVos = searchMapper.equipSearch(searchParam);
                    /*equipVos.stream().filter(e -> e.getContent() != null).forEach(s ->{
                        String[] strings = s.getContent().split("<img");
                        List<String> listImage = new ArrayList<>();
                        for (String string : strings) {
                            if (string.contains("src=")) {
                                listImage.add(string.substring(string.indexOf("src=\"") + 5, string.indexOf("\"/")));
                            }
                        }
                        s.setContentImages(listImage);
                    });*/
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, equipVos);
                case 3: //动态
                    List<SearchConcernVo> searchConcernVos = searchMapper.searchConcern(searchParam);
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, searchConcernVos);
                case 4: //场馆
                    List<SearchVenuesVo> searchVenuesVos = searchMapper.searchVenues(searchParam);
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, searchVenuesVos);
                case 5: //教程
                    List<SearchCourseVo> searchCourseVos = searchMapper.searchCourse(searchParam);
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, searchCourseVos);
                case 6: //用户
                    List<SearchUserVo> searchUserVos = searchMapper.searchUser(searchParam);
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, searchUserVos);
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
    }

    @Override
    public Map<String, Object> devaSearch(SearchDevaParam searchDevaParam) {
        if(searchDevaParam.getModel() != null && searchDevaParam.getModel() > 0 && searchDevaParam.getNumber() != null && searchDevaParam.getPageNumber() != null){
            if (searchDevaParam.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            searchDevaParam.setPageNumber((searchDevaParam.getPageNumber() - 1) * searchDevaParam.getNumber());
            List<SearchDevaVo> searchDevaVos = searchMapper.devaSearch(searchDevaParam);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, searchDevaVos);
        }else{
            return Constants.MAP_PARAM_MISS;
        }
    }
}
