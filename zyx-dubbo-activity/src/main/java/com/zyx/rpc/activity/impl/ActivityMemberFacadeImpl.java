package com.zyx.rpc.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.param.activity.ActivityMemberParam;
import com.zyx.param.activity.QueryActivityMemberParam;
import com.zyx.rpc.activity.ActivityMemberFacade;
import com.zyx.service.activity.ActivityMemberService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/9
 */
@Service("activityMemberFacade")
public class ActivityMemberFacadeImpl implements ActivityMemberFacade {
    @Resource
    private ActivityMemberService activityMemberService;

    private static Logger logger = Logger.getLogger(ActivityMemberFacadeImpl.class);

    @Override
    public Map<String, Object> insertMember(ActivityMemberParam memberParam) {
        try {
            return activityMemberService.insertMember(memberParam);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> findMemberById(QueryActivityMemberParam memberParam) {
        try {
            return activityMemberService.findMemberById(memberParam);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> findMemberByUserId(QueryActivityMemberParam memberParam) {
        try {
            return activityMemberService.findMemberByUserId(memberParam);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> delMember(QueryActivityMemberParam memberParam) {
        try {
            return activityMemberService.delMember(memberParam);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }
}
