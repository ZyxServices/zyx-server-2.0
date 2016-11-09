package com.zyx.mapper.account;

import com.zyx.entity.account.AccountInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.account.AccountInfoParam;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.param.account.UserAuthParam;
import com.zyx.vo.account.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
@Repository("accountInfoMapper")
public interface AccountInfoMapper extends BaseMapper<AccountInfo> {
    int selectAccountByPhone(String phone);

    List<AccountInfoVo> selectAccountByParam(AccountLoginParam userLoginParam);

    int renewpwd(AccountLoginParam userLoginParam);

    int updateAccountByParam(AccountInfoParam param);

    /**
     * 通过ID查询用户简单信息
     */
    QueryUserInfoVo selectAccountById(Integer id);

    MyCenterInfoVo queryMyCenterInfo(AccountLoginParam userLoginParam);

    int updateAccountAuthStatusByParam(UserAuthParam userAuthParam);

    int insertAccountAuthByParam(UserAuthParam userAuthParam);

    int updateAccountAuthByParam(UserAuthParam userAuthParam);

    int selectAccountAuthCount(Integer user_id);

    AccountAuthVo queryMyAuthInfo(int user_id);

    List<AccountAttentionVo> getNoAttentionUser(Integer loginUserId);

}
