package com.zyx.rpc.account;

import com.zyx.param.account.AccountLoginParam;

import java.util.Map;

/**
 * Created by wms on 2016/11/7.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/7
 */
public interface AccountRegisterFacade {

    /**
     * 验证手机验证码
     */
    Map<String, Object> validatePhoneCode(AccountLoginParam userLoginParam);

    /**
     * 注册
     */
    Map<String, Object> registerAccount(AccountLoginParam userLoginParam);

    /**
     * 更新密码
     */
    Map<String, Object> renewpwd(AccountLoginParam userLoginParam);

    /**
     * 忘记密码
     */
    Map<String, Object> retrievepwd(AccountLoginParam userLoginParam);

}
