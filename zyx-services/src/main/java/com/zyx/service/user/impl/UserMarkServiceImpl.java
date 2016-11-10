package com.zyx.service.user.impl;

import com.zyx.entity.user.UserMarkInfo;
import com.zyx.mapper.user.UserMarkMapper;
import com.zyx.param.user.UserMarkParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.user.UserMarkService;
import com.zyx.vo.user.MarkInfoVo;
import org.springframework.stereotype.Service;

/**
 * Created by wms on 2016/11/9.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/9
 */
@Service("userMarkService")
public class UserMarkServiceImpl extends BaseServiceImpl<UserMarkInfo> implements UserMarkService {

    public UserMarkServiceImpl() {
        super(UserMarkInfo.class);
    }

    @Override
    public MarkInfoVo queryMarkInfo(UserMarkParam userMarkParam) throws Exception {
        UserMarkMapper userMarkMapper = (UserMarkMapper) mapper;
        return userMarkMapper.queryMarkInfo(userMarkParam);
    }

    @Override
    public int updateMarkInfo(UserMarkParam userMarkParam) {
        UserMarkMapper userMarkMapper = (UserMarkMapper) mapper;
        return userMarkMapper.updateMarkInfo(userMarkParam);
    }
}
