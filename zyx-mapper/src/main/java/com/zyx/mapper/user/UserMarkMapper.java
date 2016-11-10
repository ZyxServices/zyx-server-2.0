package com.zyx.mapper.user;

import com.zyx.entity.user.UserMarkInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.user.UserMarkParam;
import com.zyx.vo.user.MarkInfoVo;

/**
 * Created by wms on 2016/11/9.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/9
 */
public interface UserMarkMapper extends BaseMapper<UserMarkInfo> {

    MarkInfoVo queryMarkInfo(UserMarkParam userMarkParam);

    int updateMarkInfo(UserMarkParam userMarkParam);
}
