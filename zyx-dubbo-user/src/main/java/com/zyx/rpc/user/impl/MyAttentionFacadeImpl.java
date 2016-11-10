package com.zyx.rpc.user.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.constants.attention.UserAttentionConstants;
import com.zyx.param.attention.AttentionParam;
import com.zyx.rpc.user.MyAttentionFacade;
import com.zyx.service.attention.UserAttentionService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountAttentionVo;
import com.zyx.vo.attention.AttentionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
@Service("myAttentionFacade")
public class MyAttentionFacadeImpl implements MyAttentionFacade {

    @Autowired
    private UserAttentionService userAttentionService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public Map<String, Object> myFSList(AttentionParam attentionParam) {
        try {
            // 判断token是否失效
            if (isTokenFailure(attentionParam.getToken())) {
                return UserAttentionConstants.MAP_TOKEN_FAILURE;
            }
            List<AttentionVo> _list = userAttentionService.myFSList(attentionParam);
            return getStringObjectMap(_list);
        } catch (Exception e) {
            e.printStackTrace();
            return UserAttentionConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myGZList(AttentionParam attentionParam) {
        try {
            // 判断token是否失效
            if (isTokenFailure(attentionParam.getToken())) {
                return UserAttentionConstants.MAP_TOKEN_FAILURE;
            }
            List<AttentionVo> _list = userAttentionService.myGZList(attentionParam);
            return getStringObjectMap(_list);
        } catch (Exception e) {
            e.printStackTrace();
            return UserAttentionConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myDKGZList(AttentionParam attentionParam) {
        try {
            // 判断token是否失效
            if (isTokenFailure(attentionParam.getToken())) {
                return UserAttentionConstants.MAP_TOKEN_FAILURE;
            }
            List<AttentionVo> _list = userAttentionService.myDKGZList(attentionParam);
            return getStringObjectMap(_list);
        } catch (Exception e) {
            e.printStackTrace();
            return UserAttentionConstants.MAP_500;
        }
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

    private Map<String, Object> getStringObjectMap(List<AttentionVo> _list) {
        if (_list == null) {
            return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70002, UserAttentionConstants.ATTENTION_70002_MSG);
        } else {
            List<AccountAttentionVo> _temp = new ArrayList<>();
            for (AttentionVo vo : _list) {
                _temp.addAll(vo.getAttentions());
            }
            return MapUtils.buildSuccessMap(_temp);
        }
    }
}
