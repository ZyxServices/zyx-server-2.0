package com.zyx.rpc.user.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.user.UserSuggestionInfo;
import com.zyx.param.user.UserSuggestionParam;
import com.zyx.rpc.user.UserSuggestionFacade;
import com.zyx.service.user.UserSuggestionService;
import com.zyx.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by wms on 2016/12/5.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/12/5
 */
@Service("userSuggestionFacade")
public class UserSuggestionFacadeImpl implements UserSuggestionFacade {
    @Autowired
    private UserSuggestionService userSuggestionService;

    @Override
    public Map<String, Object> suggest(UserSuggestionParam param) {
        try {
            UserSuggestionInfo info = buildInfo(param);
            if (userSuggestionService.save(info) >= 1) {
                return MapUtils.buildSuccessMap("反馈成功");
            }
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_40400, AccountConstants.ACCOUNT_ERROR_CODE_40400_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    private UserSuggestionInfo buildInfo(UserSuggestionParam param) {
        UserSuggestionInfo info = new UserSuggestionInfo();
        info.setUserId(param.getUserId());
        info.setContent(param.getContent());
        info.setCreateTime(System.currentTimeMillis());
        return info;
    }
}
