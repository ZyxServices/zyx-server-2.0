package com.zyx.service.account;

import com.zyx.param.account.AccountLoginParam;
import com.zyx.vo.account.AccountInfoVo;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
public interface AccountLoginService {

    AccountInfoVo loginByPhoneAndPassword(AccountLoginParam accountLoginParam);
}
