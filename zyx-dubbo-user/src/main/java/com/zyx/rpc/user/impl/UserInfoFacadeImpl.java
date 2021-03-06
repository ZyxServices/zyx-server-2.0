package com.zyx.rpc.user.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.constants.coin.CoinConstants;
import com.zyx.param.account.AccountInfoParam;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.param.account.UserAuthParam;
import com.zyx.rpc.user.UserInfoFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.coin.SportCoinService;
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
@Service("userInfoFacade")
public class UserInfoFacadeImpl implements UserInfoFacade {

    @Autowired
    private AccountInfoService accountInfoService;
    @Autowired
    SportCoinService sportCoinService;
    @Override
    public Map<String, Object> queryAccountInfo(String token, int userId) {
        try {
            AccountLoginParam accountLoginParam = new AccountLoginParam();
            accountLoginParam.setToken(token);
            accountLoginParam.setId(userId);
            List<AccountInfoVo> list = accountInfoService.selectAccountByParam(accountLoginParam);
            if (list == null || list.size() == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40300, AccountConstants.ACCOUNT_ERROR_CODE_40300_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editAccountInfo(String token, int userId, AccountInfoParam param) {
        try {
            param.setId(userId);
            param.setToken(token);
            if (accountInfoService.updateAccountByParam(param) >= 1) {
                //完善用户信息 获得运动币
                sportCoinService.modifyCoin(userId, CoinConstants.OperType.REFINED_INFO);
                return MapUtils.buildSuccessMap("用户信息修改成功");
            }
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40002, AccountConstants.ACCOUNT_ERROR_CODE_40002_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editAccountAuth(String token, int userId, UserAuthParam param) {
        try {
            param.setId(userId);
            param.setUserId(userId);
            param.setToken(token);
            param.setAuthenticate(1);
            int result = accountInfoService.submitAccountAuthByParam(param);
            if (result >= 1) {
                return MapUtils.buildSuccessMap("提交认证信息成功");
            }
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40015, AccountConstants.ACCOUNT_ERROR_CODE_40015_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryMyCenterInfo(String token, int userId) {
        try {
            AccountLoginParam userLoginParam = new AccountLoginParam();
            userLoginParam.setId(userId);
            MyCenterInfoVo _info = accountInfoService.queryMyCenterInfo(userLoginParam);
            if (_info != null) {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", _info);
            }
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40300, AccountConstants.ACCOUNT_ERROR_CODE_40300_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryMyAuthInfo(String token, int userId) {
        try {
            AccountAuthVo _info = accountInfoService.queryMyAuthInfo(userId);
            if (_info != null) {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", _info);
            }
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40300, AccountConstants.ACCOUNT_ERROR_CODE_40300_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }
}
