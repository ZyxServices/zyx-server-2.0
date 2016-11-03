package com.zyx.rpc.point.impl;

import com.zyx.constants.point.PointConstants;
import com.zyx.entity.point.UserPointInfo;
import com.zyx.param.point.UserPointParam;
import com.zyx.rpc.point.UserPointFacade;
import com.zyx.service.point.UserPointService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.point.UserPointVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
@Service("userPointFacade")
public class UserPointFacadeImpl implements UserPointFacade {

    @Autowired
    private UserPointService userPointService;

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    @Override
    public Map<String, Object> queryUserPoint(UserPointParam userPointParam) {
        try {
            UserPointVo userPointVo = userPointService.queryUserPoint(userPointParam);
            return MapUtils.buildSuccessMap(userPointVo);
        } catch (Exception e) {
            e.printStackTrace();
            return PointConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> recordPoint(UserPointParam userPointParam) {

        try {
            UserPointVo userPointVo = userPointService.queryUserPoint(userPointParam);
            return doRecordPoint(userPointVo, userPointParam);
        } catch (Exception e) {
            e.printStackTrace();
            return PointConstants.MAP_500;
        }
    }

    private Map<String, Object> doRecordPoint(UserPointVo userPointVo, UserPointParam userPointParam) {
        return null == userPointVo ? insertUserPoint(userPointParam) : modifyUserPoint(userPointVo, userPointParam);
    }

    private Map<String, Object> modifyUserPoint(UserPointVo userPointVo, UserPointParam userPointParam) {

        Long t = System.currentTimeMillis();
        userPointParam.setModifyTime(t);
        userPointParam.setId(userPointVo.getId());

        try {
            if (userPointService.modifyUserPoint(userPointParam) >= 1) {
                return MapUtils.buildSuccessMap(PointConstants.SUCCESS, "积分" + userPointParam.getPointCount(), null);
            }
            return MapUtils.buildErrorMap(PointConstants.ERROR, PointConstants.ERROR_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return PointConstants.MAP_500;
        }
    }

    private Map<String, Object> insertUserPoint(UserPointParam userPointParam) {
        UserPointInfo userPointInfo = new UserPointInfo();
        Long t = System.currentTimeMillis();
        userPointInfo.setCreateTime(t);
        userPointInfo.setModifyTime(t);
        userPointInfo.setUserId(userPointParam.getUserId());
        userPointInfo.setPointCount(userPointParam.getPointCount());
        userPointInfo.setPointType(userPointParam.getPointType());
        userPointParam.setModifyTime(t);
        try {
            // 插入方法加锁实现
            rwl.writeLock().lock();
            UserPointVo userPointVo = userPointService.queryUserPoint(userPointParam);
            if (null == userPointVo) {
                if (userPointService.insertUserPoint(userPointInfo, userPointParam) >= 1) {
                    return MapUtils.buildSuccessMap(PointConstants.SUCCESS, "积分" + userPointParam.getPointCount(), null);
                }
            } else {
                return modifyUserPoint(userPointVo, userPointParam);
            }
            return MapUtils.buildErrorMap(PointConstants.ERROR, PointConstants.ERROR_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return PointConstants.MAP_500;
        } finally {
            rwl.writeLock().unlock();
        }

    }
}
