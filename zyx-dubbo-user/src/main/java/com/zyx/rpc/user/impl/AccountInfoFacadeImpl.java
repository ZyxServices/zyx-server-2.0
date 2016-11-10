package com.zyx.rpc.user.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.param.account.AccountInfoParam;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.param.account.UserAuthParam;
import com.zyx.rpc.user.AccountInfoFacade;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountAuthVo;
import com.zyx.vo.account.AccountInfoVo;
import com.zyx.vo.account.MyCenterInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("accountInfoFacade")
public class AccountInfoFacadeImpl implements AccountInfoFacade {

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    private TokenFacade tokenFacade;

    @Override
    public Map<String, Object> queryAccountInfo(String token, int userId) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(token, userId);
            if (map != null) {
                return map;
            }
            AccountLoginParam userLoginParam = new AccountLoginParam();
            userLoginParam.setToken(token);
            userLoginParam.setId(userId);
            List<AccountInfoVo> list = accountInfoService.selectAccountByParam(userLoginParam);
            if (list == null || list.size() == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40300, AccountConstants.ACCOUNT_ERROR_CODE_40300_MSG);
            } else {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", list.get(0));
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editAccountInfo(String token, int userId, AccountInfoParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(token, userId);
            if (map != null) {
                return map;
            }
            param.setId(userId);
            param.setToken(token);
            int result = accountInfoService.updateAccountByParam(param);
            if (result >= 1) {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息修改成功", null);
            } else {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40002, AccountConstants.ACCOUNT_ERROR_CODE_40002_MSG);
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editAccountAuth(String token, int userId, UserAuthParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(token, userId);
            if (map != null) {
                return map;
            }
            param.setId(userId);
            param.setUserId(userId);
            param.setToken(token);
            param.setAuthenticate(1);
            int result = accountInfoService.submitAccountAuthByParam(param);
            if (result >= 1) {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "提交认证信息成功", null);
            } else {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40015, AccountConstants.ACCOUNT_ERROR_CODE_40015_MSG);
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryMyCenterInfo(String token, int userId) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateTokenIncludeOther(token, userId);
            if (map != null) {
                return map;
            }
            AccountLoginParam userLoginParam = new AccountLoginParam();
            userLoginParam.setId(userId);
            MyCenterInfoVo _info = accountInfoService.queryMyCenterInfo(userLoginParam);
            if (_info == null) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40300, AccountConstants.ACCOUNT_ERROR_CODE_40300_MSG);
            } else {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", _info);
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryMyAuthInfo(String token, int userId) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(token, userId);
            if (map != null) {
                return map;
            }
            AccountAuthVo _info = accountInfoService.queryMyAuthInfo(userId);
            if (_info == null) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40300, AccountConstants.ACCOUNT_ERROR_CODE_40300_MSG);
            } else {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", _info);
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

}
