package com.zyx.mapper.account;

import com.zyx.entity.account.AccountInfoAboutLogin;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.stereotype.Repository;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
@Repository("accountLoginMapper")
public interface AccountLoginMapper extends BaseMapper<AccountInfoAboutLogin> {

    AccountInfoVo loginByPhoneAndPassword(AccountLoginParam userLoginParam);
}
