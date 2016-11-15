package com.zyx.rpc.attention.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.constants.attention.UserAttentionConstants;
import com.zyx.entity.attention.UserAttention;
import com.zyx.param.attention.AttentionParam;
import com.zyx.rpc.attention.UserAttentionFacade;
import com.zyx.service.attention.UserAttentionService;
import com.zyx.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
@Service("userAttentionFacade")
public class UserAttentionFacadeImpl implements UserAttentionFacade {

    @Autowired
    private UserAttentionService userAttentionService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public Map<String, Object> attentionFromAToB(AttentionParam attentionParam) {
        try {
            // 判断token是否失效
            if (isTokenFailure(attentionParam.getToken())) {
                return UserAttentionConstants.MAP_TOKEN_FAILURE;
            }
            if (attentionParam.getFromId().equals(attentionParam.getToId())) {
                return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70005, UserAttentionConstants.ATTENTION_70005_MSG);
            }
            UserAttention _attention = buildUserAttention(attentionParam);
            attentionParam.setType(1);// 关注、粉丝
            if (userAttentionService.selectAttentionCount(attentionParam) > 0) {
                return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70003, UserAttentionConstants.ATTENTION_70003_MSG);
            }
            int result = userAttentionService.save(_attention);
            if (result == 1) {// 成功
                return MapUtils.buildSuccessMap(UserAttentionConstants.SUCCESS, UserAttentionConstants.SUCCESS_MSG, result);
            } else {
                return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70001, UserAttentionConstants.ATTENTION_70001_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return UserAttentionConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> unAttentionFromAToB(AttentionParam attentionParam) {
        try {
            // 判断token是否失效
            if (isTokenFailure(attentionParam.getToken())) {
                return UserAttentionConstants.MAP_TOKEN_FAILURE;
            }
            attentionParam.setType(1);// 关注、粉丝
            int result = userAttentionService.deleteAttention(attentionParam);
            if (result == 1) {// 成功
                return MapUtils.buildSuccessMap(UserAttentionConstants.SUCCESS, UserAttentionConstants.SUCCESS_MSG, result);
            } else {
                return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70004, UserAttentionConstants.ATTENTION_70004_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return UserAttentionConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> checkAttentionFromAToB(AttentionParam param) {
        try {
            // 判断token是否失效
            if (isTokenFailure(param.getToken())) {
                return UserAttentionConstants.MAP_TOKEN_FAILURE;
            }
            param.setType(1);
            return MapUtils.buildSuccessMap(userAttentionService.selectAttentionCount(param));
        } catch (Exception e) {
            e.printStackTrace();
            return UserAttentionConstants.MAP_500;
        }
    }

    private UserAttention buildUserAttention(AttentionParam param) {
        UserAttention _temp = new UserAttention();
        _temp.setFromUserId(param.getFromId());
        _temp.setToUserId(param.getToId());
        _temp.setRelType(param.getType());
        _temp.setCreateTime(System.currentTimeMillis());
        return _temp;
    }

    private boolean isTokenFailure(String token) {
        if (StringUtils.isEmpty(token)) {
            return true;
        }
        if (Constants.OTHER_TOKEN.equals(token)) {
            return false;
        }
        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        return StringUtils.isEmpty(phone);
    }
}
