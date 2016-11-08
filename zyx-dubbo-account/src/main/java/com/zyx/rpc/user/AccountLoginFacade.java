package com.zyx.rpc.user;

import java.util.Map;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
public interface AccountLoginFacade {
    /**
     * 手机号密码登录
     */
    Map<String, Object> loginByPhoneAndPassword(String phone, String password);

    /**
     * 退出登录
     */
    Map<String, Object> logOut(String token);

    /**
     * 刷新token
     */
    Map<String, Object> refreshToken(String token);
}
