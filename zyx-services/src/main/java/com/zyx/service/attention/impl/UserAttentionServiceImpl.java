package com.zyx.service.attention.impl;

import com.zyx.entity.attention.UserAttention;
import com.zyx.mapper.attention.UserAttentionMapper;
import com.zyx.param.attention.AttentionParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.attention.UserAttentionService;
import com.zyx.vo.attention.AttentionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
@Service("userAttentionService")
public class UserAttentionServiceImpl extends BaseServiceImpl<UserAttention> implements UserAttentionService {

    @Autowired
    private UserAttentionMapper userAttentionMapper;

    public UserAttentionServiceImpl() {
        super(UserAttention.class);
    }

    @Override
    public List<AttentionVo> myFSList(AttentionParam attentionParam) {
        return userAttentionMapper.myFSList(attentionParam);
    }

    @Override
    public List<AttentionVo> myGZList(AttentionParam attentionParam) {
        return userAttentionMapper.myGZList(attentionParam);
    }

    @Override
    public int selectAttentionCount(AttentionParam attentionParam) {
        return userAttentionMapper.selectAttentionCount(attentionParam);
    }

    @Override
    public List<AttentionVo> myDKGZList(AttentionParam attentionParam) {
        return userAttentionMapper.myDKGZList(attentionParam);
    }

    @Override
    public int deleteAttention(AttentionParam attentionParam) {
        return userAttentionMapper.deleteAttention(attentionParam);
    }

    @Override
    public int addAttention(AttentionParam attentionParam) {
        UserAttention attention = new UserAttention();
        attention.setFromUserId(attentionParam.getFromId());
        attention.setToUserId(attentionParam.getToId());
        attention.setRelType(attentionParam.getType());
        attention.setCreateTime(new Date().getTime());
        return save(attention);
    }
}
