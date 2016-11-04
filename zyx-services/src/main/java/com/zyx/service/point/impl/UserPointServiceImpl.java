package com.zyx.service.point.impl;

import com.zyx.entity.point.UserPointInfo;
import com.zyx.mapper.point.UserPointMapper;
import com.zyx.param.point.UserPointDetailParam;
import com.zyx.param.point.UserPointParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.point.UserPointService;
import com.zyx.vo.point.UserPointVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
@Service("userPointService")
public class UserPointServiceImpl extends BaseServiceImpl<UserPointInfo> implements UserPointService {

    @Autowired
    private UserPointMapper userPointMapper;

    public UserPointServiceImpl() {
        super(UserPointInfo.class);
    }

    @Override
    public UserPointVo queryUserPoint(UserPointParam userPointParam) {
        return userPointMapper.queryUserPoint(userPointParam);
    }

    @Override
    public int insertUserPoint(UserPointInfo userPointInfo, UserPointParam userPointParam) throws Exception {
        if (save(userPointInfo) >= 1) {
            return doInsertPointDetail(userPointParam);
        }
        return 0;
    }

    @Override
    public int modifyUserPoint(UserPointParam userPointParam) throws Exception {
        if (userPointMapper.modifyUserPoint(userPointParam) >= 1) {
            return doInsertPointDetail(userPointParam);
        }
        return 0;
    }

    private int doInsertPointDetail(UserPointParam userPointParam) throws Exception {
        UserPointDetailParam userPointDetailParam = new UserPointDetailParam();
        userPointDetailParam.setUserId(userPointParam.getUserId());
        userPointDetailParam.setCreateTime(userPointParam.getModifyTime());
        userPointDetailParam.setPointCount(userPointParam.getPointCount());
        userPointDetailParam.setPointType(userPointParam.getPointType());
        userPointDetailParam.setDetailType(userPointParam.getDetailType());
        userPointDetailParam.setDetailMsg(userPointParam.getDetailMsg());
        userPointDetailParam.setDetailTable(userPointParam.getDetailTable());
        return userPointMapper.insertPointDetail(userPointDetailParam);
    }
}
