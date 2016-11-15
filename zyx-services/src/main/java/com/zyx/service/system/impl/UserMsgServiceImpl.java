package com.zyx.service.system.impl;

import com.zyx.entity.account.UserMsgInfo;
import com.zyx.mapper.system.UserMsgMapper;
import com.zyx.param.account.UserMsgParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.system.UserMsgService;
import com.zyx.vo.account.MsgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wms on 2016/11/15.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/15.
 */
@Service("userMsgService")
public class UserMsgServiceImpl extends BaseServiceImpl<UserMsgInfo> implements UserMsgService {

    @Autowired
    private UserMsgMapper userMsgMapper;

    public UserMsgServiceImpl() {
        super(UserMsgInfo.class);
    }

    @Override
    public Long queryMsgCount(UserMsgParam userMsgParam) {
        return userMsgMapper.queryMsgCount(userMsgParam);
    }

    @Override
    public List<MsgVo> queryMsgList(UserMsgParam userMsgParam) {
        return userMsgMapper.queryMsgList(userMsgParam);
    }

    @Override
    public int deleteMsg(UserMsgParam userMsgParam) {
        return userMsgMapper.deleteMsg(userMsgParam);
    }
}
