package com.zyx.service.account.impl;

import com.zyx.entity.account.AccountInfo;
import com.zyx.entity.attention.UserAttention;
import com.zyx.mapper.account.AccountInfoMapper;
import com.zyx.mapper.attention.UserAttentionMapper;
import com.zyx.param.account.AccountInfoParam;
import com.zyx.param.account.AccountLoginParam;
import com.zyx.param.account.UserAuthParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.account.AccountInfoService;
import com.zyx.vo.account.AccountAttentionVo;
import com.zyx.vo.account.AccountAuthVo;
import com.zyx.vo.account.AccountInfoVo;
import com.zyx.vo.account.MyCenterInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
@Service("accountInfoService")
public class AccountInfoServiceImpl extends BaseServiceImpl<AccountInfo> implements AccountInfoService {

    @Autowired
    private UserAttentionMapper userAttentionMapper;

    public AccountInfoServiceImpl() {
        super(AccountInfo.class);
    }

    @Resource
    private AccountInfoMapper accountInfoMapper;

    @Override
    public int insertAccountInfo(AccountInfo entity, UserAttention userAttention) {
        int result = save(entity);
        if (result != 0) {
            userAttention.setFromUserId(entity.getId());
            userAttention.setToUserId(entity.getId());
            result = userAttentionMapper.insert(userAttention);
        }
        return result;
    }

    @Override
    public int selectAccountByPhone(String phone) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.selectAccountByPhone(phone);
    }

    @Override
    public List<AccountInfoVo> selectAccountByParam(AccountLoginParam userLoginParam) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.selectAccountByParam(userLoginParam);
    }

    @Override
    public int renewSecret(AccountLoginParam userLoginParam) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.renewpwd(userLoginParam);
    }

    @Override
    public int updateAccountByParam(AccountInfoParam param) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.updateAccountByParam(param);
    }

    @Override
    public List<AccountInfo> selectBaseInfo(List<Integer> ids) {
        return selectByIds(ids, "id", "createTime", "phone", "nickname", "sex", "avatar");
    }

    @Override
    public MyCenterInfoVo queryMyCenterInfo(AccountLoginParam userLoginParam) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.queryMyCenterInfo(userLoginParam);
    }

    @Override
    public int submitAccountAuthByParam(UserAuthParam userAuthParam) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        int result = accountInfoMapper.updateAccountAuthStatusByParam(userAuthParam);
        if (result == 1) {
            int temp = accountInfoMapper.selectAccountAuthCount(userAuthParam.getUserId());
            if (temp != 0) {
                result = accountInfoMapper.updateAccountAuthByParam(userAuthParam);
            } else {
                result = accountInfoMapper.insertAccountAuthByParam(userAuthParam);
            }
        }
        return result;
    }

    @Override
    public AccountAuthVo queryMyAuthInfo(int userId) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.queryMyAuthInfo(userId);
    }

    @Override
    public List<AccountAttentionVo> getNoAttentionUser(Integer loginUserId) {
        return accountInfoMapper.getNoAttentionUser(loginUserId);
    }

}
