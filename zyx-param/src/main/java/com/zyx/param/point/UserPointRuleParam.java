package com.zyx.param.point;

import java.io.Serializable;

/**
 * Created by wms on 2016/11/11.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/11
 */
public class UserPointRuleParam implements Serializable {
    private static final long serialVersionUID = -1901741693286871150L;

    // 【1】每日，【2】每月，【3】全部
    private Integer ruleType;

    private Integer count;

    public UserPointRuleParam(Integer ruleType, Integer count) {
        this.ruleType = ruleType;
        this.count = count;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
