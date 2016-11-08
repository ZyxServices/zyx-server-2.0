package com.zyx.rpc.user.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.rpc.user.AccountSecretFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.account.AccountRedisService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
@Service("accountSecretFacade")
public class AccountSecretFacadeImpl implements AccountSecretFacade {

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private AccountRedisService accountRedisService;

    @Override
    public Map<String, Object> renewSecret(AccountLoginParam userLoginParam) {
        try {
            String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + userLoginParam.getToken());
            // 判断token是否失效
            if (phone == null) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            userLoginParam.setPhone(phone);
            userLoginParam.setPassword(userLoginParam.getPassword());
            List<AccountInfoVo> list = accountInfoService.selectAccountByParam(userLoginParam);
            if (list == null || list.size() == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40001, AccountConstants.ACCOUNT_ERROR_CODE_40001_MSG);
            }
            userLoginParam.setPassword2(userLoginParam.getPassword2());
            int result = accountInfoService.renewpwd(userLoginParam);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40002, AccountConstants.ACCOUNT_ERROR_CODE_40002_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户密码修改成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> retrieveSecret(AccountLoginParam userLoginParam) {
        try {
            // 判断缓存中手机号码和验证码是否对应
            String redis_code = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + userLoginParam.getPhone());
//        if (!userLoginParam.getCode().equals(redis_code)) {
//            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50006);
//            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50006_MSG);
//            return map;
//        }

            if (StringUtils.isEmpty(redis_code)) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40011, AccountConstants.ACCOUNT_ERROR_CODE_40011_MSG);
            }

            // 验证密码是否输入一致
            if (!userLoginParam.getPassword().equals(userLoginParam.getPassword2())) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40012, AccountConstants.ACCOUNT_ERROR_CODE_40012_MSG);
            }

            userLoginParam.setPassword2(userLoginParam.getPassword2());
            int result = accountInfoService.renewpwd(userLoginParam);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40002, AccountConstants.ACCOUNT_ERROR_CODE_40002_MSG);
            }
            stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_PHONE_CODE + userLoginParam.getPhone());
            String temp = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_PHONE + userLoginParam.getPhone());
            if (temp != null) {
                String token = temp.substring(temp.indexOf("【") + 1, temp.indexOf("】"));
                stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
                stringRedisTemplate.delete(AccountConstants.REDIS_KEY_TYJ_PHONE + userLoginParam.getPhone());
                accountRedisService.delete(userLoginParam.getPhone());
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户密码修改成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }
}
