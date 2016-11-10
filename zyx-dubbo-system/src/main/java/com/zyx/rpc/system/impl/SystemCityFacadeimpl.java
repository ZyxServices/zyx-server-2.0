package com.zyx.rpc.system.impl;

import com.zyx.constants.Constants;
import com.zyx.rpc.system.SystemCityFacade;
import com.zyx.service.system.SystemCityService;
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
 * @since 2016/11/10
 */
@Service("systemCityFacade")
public class SystemCityFacadeimpl implements SystemCityFacade {
    @Resource
    private SystemCityService activityParam;

    private static Logger logger = Logger.getLogger(SystemCityFacadeimpl.class);

    @Override
    public Map<String, Object> findHotCity() {
        try {
            return activityParam.findHotCity();
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }
}
