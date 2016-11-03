package com.zyx.rpc.point;

import com.zyx.param.point.UserPointParam;

import java.util.Map;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
public interface UserPointFacade {

    /**
     * 获取用户积分
     */
    Map<String, Object> queryUserPoint(UserPointParam userPointParam);

    /**
     * 记录用户积分
     */
    Map<String, Object> recordPoint(UserPointParam userPointParam);
}
