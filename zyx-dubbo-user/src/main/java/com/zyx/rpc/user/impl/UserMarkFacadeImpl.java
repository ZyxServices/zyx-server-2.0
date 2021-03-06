package com.zyx.rpc.user.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.user.UserMarkInfo;
import com.zyx.param.user.UserMarkParam;
import com.zyx.rpc.user.UserMarkFacade;
import com.zyx.service.user.UserMarkService;
import com.zyx.utils.DateUtils;
import com.zyx.utils.MapUtils;
import com.zyx.vo.user.MarkInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
@Service("userMarkFacade")
public class UserMarkFacadeImpl implements UserMarkFacade {

    @Autowired
    private UserMarkService userMarkService;

    @Override
    public Map<String, Object> sign(UserMarkParam userMarkParam) {
        try {
            // 查询用户签到信息
            MarkInfoVo markInfoVo = userMarkService.queryMarkInfo(userMarkParam);
            if (markInfoVo != null) {// 查询到进行更新
                return modifyMarkInfo(userMarkParam, markInfoVo);
            }
            return insertMarkInfo(userMarkParam);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> querySign(UserMarkParam userMarkParam) {
        try {
            // 查询用户签到信息
            MarkInfoVo markInfoVo = userMarkService.queryMarkInfo(userMarkParam);
            if (markInfoVo != null) {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户签到信息查询成功", markInfoVo);
            }
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40202, AccountConstants.ACCOUNT_ERROR_CODE_40202_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    private Map<String, Object> modifyMarkInfo(UserMarkParam userMarkParam, MarkInfoVo markInfoVo) {
        Timestamp lastModifyTimeStamp = new Timestamp(markInfoVo.getMarkTime());
        Timestamp todayStartTimeStamp = DateUtils.getTodayStartTimeStamp();
        if (lastModifyTimeStamp.after(todayStartTimeStamp)) {// 今天已经签过到了
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40201, AccountConstants.ACCOUNT_ERROR_CODE_40201_MSG);
        } else {
            Long t = System.currentTimeMillis();
            final long missDays = DateUtils.getMissDay(t, markInfoVo.getMarkTime());
            if (missDays == 1) {//连续签到，连续签到次数增加1 ，签到历史移动一位
                userMarkParam.setMarkCount(markInfoVo.getMarkCount() + 1);
            } else {
                userMarkParam.setMarkCount(1);
            }
            userMarkParam.setMarkTime(t);
            userMarkParam.setId(markInfoVo.getId());

            try {
                userMarkParam.setMarkHistory(getMarkHistory(markInfoVo.getMarkHistory(), t));
                int result = userMarkService.updateMarkInfo(userMarkParam);
                if (result >= 1) {
                    return MapUtils.buildSuccessMap("用户签到成功");
                } else {
                    return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40203, AccountConstants.ACCOUNT_ERROR_CODE_40203_MSG);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return AccountConstants.MAP_500;
            }

        }
    }

    private Map<String, Object> insertMarkInfo(UserMarkParam userMarkParam) {
        UserMarkInfo userMarkInfo = new UserMarkInfo();
        Long t = System.currentTimeMillis();
        userMarkInfo.setMarkTime(t);
        userMarkInfo.setMarkCount(1);
        userMarkInfo.setCreateTime(t);
        userMarkInfo.setUserId(userMarkParam.getUserId());
        try {
            String history = getMarkHistory(t);
            userMarkInfo.setMarkHistory(history);
            int result = userMarkService.save(userMarkInfo);
            if (result >= 1) {
                return MapUtils.buildSuccessMap("用户签到成功");
            } else {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40200, AccountConstants.ACCOUNT_ERROR_CODE_40200_MSG);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    /**
     * 创建时
     */
    private String getMarkHistory(Long t) throws IOException {
        Map<Integer, int[]> map = new HashMap<>();
        int[] days = new int[400];
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(t);
        days[calendar.get(Calendar.DAY_OF_YEAR)] = 1;
        map.put(calendar.get(Calendar.YEAR), days);
        return JSON.json(map);
    }

    /**
     * 更新时
     */
    private String getMarkHistory(String markHistory, Long t) throws Exception {
        Map<String, Object> map = JSON.parse(markHistory, Map.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(t);
        if (map.get(calendar.get(Calendar.YEAR) + "") == null) {
            int[] days = new int[400];
            days[calendar.get(Calendar.DAY_OF_YEAR)] = 1;
            map.put(calendar.get(Calendar.YEAR) + "", days);
        } else {
            ArrayList days = (ArrayList) map.get(calendar.get(Calendar.YEAR) + "");
            days.set(calendar.get(Calendar.DAY_OF_YEAR), 1L);
            map.put(calendar.get(Calendar.YEAR) + "", days);
        }
        return JSON.json(map);
    }

}
