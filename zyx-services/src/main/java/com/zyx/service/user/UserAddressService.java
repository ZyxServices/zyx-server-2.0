package com.zyx.service.user;


import com.zyx.entity.user.UserAddressInfo;
import com.zyx.param.user.UserAddressParam;
import com.zyx.service.BaseService;
import com.zyx.vo.user.UserAddressVo;

import java.util.List;

/**
 * Created by wms on 2016/11/10.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/10
 */
public interface UserAddressService extends BaseService<UserAddressInfo> {
    UserAddressVo selectAddressByAddressId(UserAddressParam userAddressParam);

    List<UserAddressVo> selectAddressList(UserAddressParam userAddressParam);

    int insertAccountAddressInfo(UserAddressParam userAddressParam);

    int deleteByAddressId(UserAddressParam userAddressParam);

    int setDefaultReceiptAddress(UserAddressParam userAddressParam) throws Exception;

    int editReceiptAddress(UserAddressParam userAddressParam);
}
