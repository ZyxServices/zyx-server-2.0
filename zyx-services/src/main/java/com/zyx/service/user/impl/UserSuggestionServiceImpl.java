package com.zyx.service.user.impl;

import com.zyx.entity.user.UserSuggestionInfo;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.user.UserSuggestionService;
import org.springframework.stereotype.Service;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
@Service("userSuggestionService")
public class UserSuggestionServiceImpl extends BaseServiceImpl<UserSuggestionInfo> implements UserSuggestionService {

    public UserSuggestionServiceImpl() {
        super(UserSuggestionInfo.class);
    }
}
