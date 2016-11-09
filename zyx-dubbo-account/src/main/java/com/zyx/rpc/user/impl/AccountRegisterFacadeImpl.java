package com.zyx.rpc.user.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.AccountInfo;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.rpc.user.AccountRegisterFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wms on 2016/11/7.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/7
 */
@Service("accountRegisterFacade")
public class AccountRegisterFacadeImpl implements AccountRegisterFacade {

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public Map<String, Object> validatePhone(AccountLoginParam userLoginParam) {
        try {
            // 判断手机号是否已经注册
            int count = accountInfoService.selectAccountByPhone(userLoginParam.getPhone());
            if (count != 0) {// 手机号码重复
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40005, AccountConstants.ACCOUNT_ERROR_CODE_40005_MSG);
            } else {
                return MapUtils.buildSuccessMap();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> validatePhoneCode(AccountLoginParam userLoginParam) {
        try {
            // 判断缓存中手机号码和验证码是否对应
            String redis_code = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + userLoginParam.getPhone());

            if (StringUtils.isEmpty(redis_code)) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40011, AccountConstants.ACCOUNT_ERROR_CODE_40011_MSG);
            }

            if (!userLoginParam.getCode().equals(redis_code)) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40006, AccountConstants.ACCOUNT_ERROR_CODE_40006_MSG);
            }
            // 验证成功
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("phone", userLoginParam.getPhone());
            map.put("code", userLoginParam.getCode());
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "手机号和验证码匹配成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> registerAccount(AccountLoginParam userLoginParam) {
        try {
            // 判断手机号是否已经注册
            int count = accountInfoService.selectAccountByPhone(userLoginParam.getPhone());
            if (count != 0) {// 手机号码重复
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40005, AccountConstants.ACCOUNT_ERROR_CODE_40005_MSG);
            }

            // 判断缓存中手机号码和验证码是否对应
            String redis_code = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + userLoginParam.getPhone());
//        if (!userLoginParam.getCode().equals(redis_code)) {
//            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50006);
//            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50006_MSG);
//            return map;
//        }
            // 判断缓存中手机号码是否存在验证码
            if (StringUtils.isEmpty(redis_code)) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40011, AccountConstants.ACCOUNT_ERROR_CODE_40011_MSG);
            }

            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setPhone(userLoginParam.getPhone());
            accountInfo.setPassword(userLoginParam.getPassword());
            accountInfo.setNickname(userLoginParam.getNickname());
            accountInfo.setAvatar(userLoginParam.getAvatar());
            accountInfo.setCreateTime(System.currentTimeMillis());
            int result = accountInfoService.save(accountInfo);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40010, AccountConstants.ACCOUNT_ERROR_CODE_40010_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, AccountConstants.ACCOUNT_SUCCESS_CODE_40013_MSG, accountInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }
}
