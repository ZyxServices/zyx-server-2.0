package com.zyx.mapper.user;

import com.zyx.entity.user.UserAddressInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.user.UserAddressParam;
import com.zyx.vo.user.UserAddressVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wms on 2016/11/10.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/10
 */
@Repository("userAddressMapper")
public interface UserAddressMapper extends BaseMapper<UserAddressInfo> {

    UserAddressVo queryAddressInfo(UserAddressParam userAddressParam);

    List<UserAddressVo> queryAddressList(UserAddressParam userAddressParam);

    int deleteByAddressId(UserAddressParam userAddressParam);

    int setDefaultReceiptAddress(UserAddressParam userAddressParam);

    int cancelDefaultReceiptAddress(UserAddressParam userAddressParam);

    int editReceiptAddress(UserAddressParam userAddressParam);
}
