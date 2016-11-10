package com.zyx.rpc.user.impl;

import com.zyx.constants.user.UserConstants;
import com.zyx.param.user.UserAddressParam;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.rpc.user.UserAddressFacade;
import com.zyx.service.user.UserAddressService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.user.UserAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/11/10.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/10
 */
@Service("userAddressFacade")
public class UserAddressFacadeImpl implements UserAddressFacade {

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    private TokenFacade tokenFacade;

    @Override
    public Map<String, Object> insertUserAddressInfo(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken(), param.getUserId());
            if (map != null) {
                return map;
            }
            if (userAddressService.insertAccountAddressInfo(param) == 0) {
                return MapUtils.buildErrorMap(UserConstants.ACCOUNT_ERROR_CODE_50400, UserConstants.ACCOUNT_ERROR_CODE_50400_MSG);
            }
            return MapUtils.buildSuccessMap("收货地址新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return UserConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryUserAddressInfo(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken());
            if (map != null) {
                return map;
            }
            UserAddressVo userAddressVo = userAddressService.selectAddressByAddressId(param);
            if (userAddressVo == null) {
                return MapUtils.buildErrorMap(UserConstants.ACCOUNT_ERROR_CODE_50300, UserConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            }
            return MapUtils.buildSuccessMap(UserConstants.SUCCESS, "收货地址查询成功", userAddressVo);
        } catch (Exception e) {
            e.printStackTrace();
            return UserConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryUserAddressList(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken(), param.getUserId());
            if (map != null) {
                return map;
            }
            List<UserAddressVo> result = userAddressService.selectAddressList(param);
            if (result == null) {
                return MapUtils.buildErrorMap(UserConstants.ACCOUNT_ERROR_CODE_50300, UserConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            }
            return MapUtils.buildSuccessMap(UserConstants.SUCCESS, "收货地址列表查询成功", result);
        } catch (Exception e) {
            e.printStackTrace();
            return UserConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> deleteUserAddressInfo(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken());
            if (map != null) {
                return map;
            }
            if (userAddressService.deleteByAddressId(param) == 0) {
                return MapUtils.buildErrorMap(UserConstants.ACCOUNT_ERROR_CODE_50401, UserConstants.ACCOUNT_ERROR_CODE_50401_MSG);
            }
            return MapUtils.buildSuccessMap("收货地址删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return UserConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editReceiptAddress(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken(), param.getUserId());
            if (map != null) {
                return map;
            }
            if (userAddressService.editReceiptAddress(param) == 0) {
                return MapUtils.buildErrorMap(UserConstants.ACCOUNT_ERROR_CODE_50402, UserConstants.ACCOUNT_ERROR_CODE_50402_MSG);
            }
            return MapUtils.buildSuccessMap("收货地址编辑成功");
        } catch (Exception e) {
            e.printStackTrace();
            return UserConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> setDefaultReceiptAddress(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken(), param.getUserId());
            if (map != null) {
                return map;
            }
            if (userAddressService.setDefaultReceiptAddress(param) == 0) {
                return MapUtils.buildErrorMap(UserConstants.ACCOUNT_ERROR_CODE_50402, UserConstants.ACCOUNT_ERROR_CODE_50402_MSG);
            }
            return MapUtils.buildSuccessMap("默认收货地址设置成功");
        } catch (Exception e) {
            e.printStackTrace();
            return UserConstants.MAP_500;
        }
    }
}
