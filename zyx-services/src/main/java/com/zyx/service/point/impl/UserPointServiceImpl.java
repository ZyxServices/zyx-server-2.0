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

import java.util.Calendar;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

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
    public boolean checkUserPoint(UserPointParam userPointParam) {
        if (userPointParam.getRuleParam() != null) {

            int type = userPointParam.getRuleParam().getRuleType();
            int count = userPointParam.getRuleParam().getCount();
            UserPointDetailParam userPointDetailParam = getUserPointDetailParam(userPointParam);

            if (type == 1) {// 每天
                Calendar calendarMin = Calendar.getInstance();
                calendarMin.add(Calendar.DATE, -1);
                calendarMin.set(Calendar.HOUR_OF_DAY, 23);
                calendarMin.set(Calendar.MINUTE, 59);
                calendarMin.set(Calendar.SECOND, 59);
                userPointDetailParam.setCreateTimeMin(calendarMin.getTimeInMillis());
                Calendar calendarMax = Calendar.getInstance();
                calendarMax.add(Calendar.DATE, 1);
                calendarMax.set(Calendar.HOUR_OF_DAY, 0);
                calendarMax.set(Calendar.MINUTE, 0);
                calendarMax.set(Calendar.SECOND, 0);
                userPointDetailParam.setCreateTimeMax(calendarMax.getTimeInMillis());
                return userPointMapper.checkUserPointA(userPointDetailParam) < count;
            } else if (type == 2) {// 每月
                return userPointMapper.checkUserPointB(userPointDetailParam) < count;
            } else {// 全部
                return userPointMapper.checkUserPointC(userPointDetailParam) < count;
            }

        }
        return true;
    }

    @Override
    public int modifyUserPoint(UserPointParam userPointParam) throws Exception {
        try {
            rwl.writeLock().lock();
            if (checkUserPoint(userPointParam)) {
                if (userPointMapper.modifyUserPoint(userPointParam) >= 1) {
                    return doInsertPointDetail(userPointParam);
                }
            }
            return 0;
        } finally {
            rwl.writeLock().unlock();
        }
    }

    private int doInsertPointDetail(UserPointParam userPointParam) throws Exception {
        UserPointDetailParam userPointDetailParam = getUserPointDetailParam(userPointParam);
        return userPointMapper.insertPointDetail(userPointDetailParam);
    }

    private UserPointDetailParam getUserPointDetailParam(UserPointParam userPointParam) {
        UserPointDetailParam userPointDetailParam = new UserPointDetailParam();
        userPointDetailParam.setUserId(userPointParam.getUserId());
        userPointDetailParam.setCreateTime(userPointParam.getModifyTime());
        userPointDetailParam.setPointCount(userPointParam.getPointCount());
        userPointDetailParam.setPointType(userPointParam.getPointType());
        userPointDetailParam.setDetailType(userPointParam.getDetailType());
        userPointDetailParam.setDetailMsg(userPointParam.getDetailMsg());
        userPointDetailParam.setDetailTable(userPointParam.getDetailTable());
        return userPointDetailParam;
    }
}
