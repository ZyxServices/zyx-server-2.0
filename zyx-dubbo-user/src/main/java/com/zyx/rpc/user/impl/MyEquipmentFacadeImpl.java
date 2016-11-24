package com.zyx.rpc.user.impl;

import com.zyx.constants.attention.UserAttentionConstants;
import com.zyx.param.user.UserEquipmentParam;
import com.zyx.rpc.user.MyEquipmentFacade;
import com.zyx.service.zoom.EquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wms on 2016/11/24.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/24
 */
@Service("myEquipmentFacade")
public class MyEquipmentFacadeImpl implements MyEquipmentFacade {
    @Autowired
    private EquipService equipService;

    @Override
    public Map<String, Object> myEquipmentList(UserEquipmentParam userEquipmentParam) {
        try {

            if (userEquipmentParam.getPage() != null && userEquipmentParam.getPageSize() != null) {
                userEquipmentParam.setPage((userEquipmentParam.getPage() - 1) * userEquipmentParam.getPageSize());
            }

            return equipService.queryMyList(userEquipmentParam);
        } catch (Exception e) {
            e.printStackTrace();
            return UserAttentionConstants.MAP_500;
        }
    }
}
