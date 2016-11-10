package com.zyx.service.account;

import com.zyx.entity.account.AccountInfo;
import com.zyx.entity.attention.UserAttention;
import com.zyx.param.account.AccountInfoParam;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.param.account.UserAuthParam;
import com.zyx.service.BaseService;
import com.zyx.vo.account.AccountAuthVo;
import com.zyx.vo.account.AccountInfoVo;
import com.zyx.vo.account.MyCenterInfoVo;

import java.util.List;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
public interface AccountInfoService extends BaseService<AccountInfo> {
    /**
     * 添加用户
     */
    int insertAccountInfo(AccountInfo accountInfo, UserAttention userAttention);

    /**
     * 通过手机号码查询用户数量
     */
    int selectAccountByPhone(String phone);

    /**
     * 通过参数查询用户列表
     */
    List<AccountInfoVo> selectAccountByParam(AccountLoginParam userLoginParam);

    /**
     * 更新密码
     */
    int renewSecret(AccountLoginParam userLoginParam);

    /**
     * 修改用户信息
     */
    int updateAccountByParam(AccountInfoParam param);

    /**
     * 查询多个用户信息的基础信息
     */
    List<AccountInfo> selectBaseInfo(List<Integer> ids);

    /**
     * 个人中心用户信息查询接口
     */
    MyCenterInfoVo queryMyCenterInfo(AccountLoginParam userLoginParam);

    /**
     * 审核信息提交接口
     */
    int submitAccountAuthByParam(UserAuthParam userAuthParam);

    AccountAuthVo queryMyAuthInfo(int userId);
}
