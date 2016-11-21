package com.zyx.service.system.impl;

import com.zyx.constants.Constants;
import com.zyx.mapper.system.SystemCityMapper;
import com.zyx.service.system.SystemCityService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.system.CityVo;
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
 * @since 2016/11/10
 */
@Service
public class SystemCityServiceImpl implements SystemCityService {

    @Resource
    private SystemCityMapper systemCityMapper;
    @Override
    public Map<String, Object> findHotCity() {
        List<CityVo> cityVos = systemCityMapper.findHotCity();
        return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, cityVos);
    }
}
