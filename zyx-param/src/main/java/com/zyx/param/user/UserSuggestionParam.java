package com.zyx.param.user;

import com.zyx.param.BaseParam;

/**
 * Created by wms on 2016/12/5.
 * 用户意见反馈参数类
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/12/5
 */
public class UserSuggestionParam extends BaseParam {
    private static final long serialVersionUID = 5972980171337209265L;

    private Integer userId;

    private String content;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
