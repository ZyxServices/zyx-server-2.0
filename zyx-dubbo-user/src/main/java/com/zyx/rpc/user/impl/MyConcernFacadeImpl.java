package com.zyx.rpc.user.impl;

import com.zyx.constants.user.UserConstants;
import com.zyx.param.user.UserConcernParam;
import com.zyx.rpc.user.MyConcernFacade;
import com.zyx.service.zoom.ConcernService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.zoom.MyFollowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/11/9.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/9
 */
@Service("myConcernFacade")
public class MyConcernFacadeImpl implements MyConcernFacade {

    @Autowired
    private ConcernService concernService;

    @Override
    public Map<String, Object> myList(UserConcernParam userConcernParam) {
        try {
            List<MyFollowVo> _list = concernService.queryMyConcernList(userConcernParam);
            return MapUtils.buildSuccessMap(_list);
        } catch (Exception e) {
            e.printStackTrace();
            return UserConstants.MAP_500;
        }
    }
}
