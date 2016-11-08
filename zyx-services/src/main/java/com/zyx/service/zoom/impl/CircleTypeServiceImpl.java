package com.zyx.service.zoom.impl;

import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.zoom.CircleType;
import com.zyx.mapper.zoom.CircleTypeMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.zoom.CircleTypeService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom.impl
 * Create by XiaoWei on 2016/8/25
 */
@Service
public class CircleTypeServiceImpl extends BaseServiceImpl<CircleType> implements CircleTypeService {
    public CircleTypeServiceImpl() {
        super(CircleType.class);
    }

    @Resource
    private CircleTypeMapper circleTypeMapper;

    @Override
    public Map<String, Object> getList() {
        try {
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_34000_MSG, circleTypeMapper.getList());
        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }
    }
}
