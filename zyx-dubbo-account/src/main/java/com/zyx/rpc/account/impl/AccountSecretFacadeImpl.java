package com.zyx.rpc.account.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.rpc.account.AccountSecretFacade;
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
            if (accountInfoService.renewSecret(userLoginParam) >= 1) {
                return MapUtils.buildSuccessMap("用户密码修改成功");
            }
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40002, AccountConstants.ACCOUNT_ERROR_CODE_40002_MSG);
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
            if (StringUtils.isEmpty(redis_code)) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40011, AccountConstants.ACCOUNT_ERROR_CODE_40011_MSG);
            }

            if (!redis_code.equals(userLoginParam.getCode())) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40006, AccountConstants.ACCOUNT_ERROR_CODE_40006_MSG);
            }

            // 验证密码是否输入一致
//            if (!userLoginParam.getPassword().equals(userLoginParam.getPassword2())) {
//                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40012, AccountConstants.ACCOUNT_ERROR_CODE_40012_MSG);
//            }

            userLoginParam.setPassword2(userLoginParam.getPassword2());
            if (accountInfoService.renewSecret(userLoginParam) == 0) {
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
            return MapUtils.buildSuccessMap("用户密码修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }
}
