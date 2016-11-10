package com.zyx.service.user.impl;

import com.zyx.entity.user.UserAddressInfo;
import com.zyx.mapper.user.UserAddressMapper;
import com.zyx.param.user.UserAddressParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.user.UserAddressService;
import com.zyx.vo.user.UserAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wms on 2016/11/10.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/10
 */
@Service("userAddressService")
public class UserAddressServiceImpl extends BaseServiceImpl<UserAddressInfo> implements UserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    public UserAddressServiceImpl() {
        super(UserAddressInfo.class);
    }

    @Override
    public int insertAccountAddressInfo(UserAddressParam param) {
        UserAddressInfo userAddressInfo = new UserAddressInfo();
        userAddressInfo.setUserId(param.getUserId());
        userAddressInfo.setAddressId(param.getAddressId());
        userAddressInfo.setReceiver(param.getReceiver());
        userAddressInfo.setPhone(param.getPhone());
        userAddressInfo.setZipCode(param.getZipCode());
        userAddressInfo.setContent(param.getContent());
        userAddressInfo.setStatus(false);
        userAddressInfo.setCreateTime(System.currentTimeMillis());
        return mapper.insert(userAddressInfo);
    }

    @Override
    public UserAddressVo selectAddressByAddressId(UserAddressParam userAddressParam) {
        UserAddressMapper userAddressMapper = (UserAddressMapper) mapper;
        return userAddressMapper.queryAddressInfo(userAddressParam);
    }

    @Override
    public List<UserAddressVo> selectAddressList(UserAddressParam userAddressParam) {
        UserAddressMapper userAddressMapper = (UserAddressMapper) mapper;
        return userAddressMapper.queryAddressList(userAddressParam);
    }

    @Override
    public int deleteByAddressId(UserAddressParam userAddressParam) {
        UserAddressMapper userAddressMapper = (UserAddressMapper) mapper;
        return userAddressMapper.deleteByAddressId(userAddressParam);
    }

    @Override
    public int editReceiptAddress(UserAddressParam userAddressParam) {
        UserAddressMapper userAddressMapper = (UserAddressMapper) mapper;
        return userAddressMapper.editReceiptAddress(userAddressParam);
    }

    @Override
    public int setDefaultReceiptAddress(UserAddressParam userAddressParam) throws Exception {
        int result = userAddressMapper.setDefaultReceiptAddress(userAddressParam);
        if (result == 1) {
            userAddressMapper.cancelDefaultReceiptAddress(userAddressParam);
        }
        return result;
    }

}
