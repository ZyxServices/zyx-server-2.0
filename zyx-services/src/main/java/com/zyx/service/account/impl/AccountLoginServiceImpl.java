package com.zyx.service.account.impl;

import com.zyx.entity.account.AccountInfoAboutLogin;
import com.zyx.mapper.account.AccountLoginMapper;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.account.AccountLoginService;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.stereotype.Service;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
@Service("accountLoginService")
public class AccountLoginServiceImpl extends BaseServiceImpl<AccountInfoAboutLogin> implements AccountLoginService {

    public AccountLoginServiceImpl() {
        super(AccountInfoAboutLogin.class);
    }

    @Override
    public AccountInfoVo loginByPhoneAndPassword(AccountLoginParam accountLoginParam) {
        AccountLoginMapper accountLoginMapper = (AccountLoginMapper) mapper;
        return accountLoginMapper.loginByPhoneAndPassword(accountLoginParam);
    }
}
