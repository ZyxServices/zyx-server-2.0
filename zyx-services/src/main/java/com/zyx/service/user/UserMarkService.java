package com.zyx.service.user;

import com.zyx.entity.user.UserMarkInfo;
import com.zyx.param.user.UserMarkParam;
import com.zyx.service.BaseService;
import com.zyx.vo.user.MarkInfoVo;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
public interface UserMarkService extends BaseService<UserMarkInfo> {
    MarkInfoVo queryMarkInfo(UserMarkParam userMarkParam) throws Exception;

    int updateMarkInfo(UserMarkParam userMarkParam);
}
