package com.zyx.vo.account;

import java.io.Serializable;

/**
 * Created by wms on 2016/12/6.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/12/6
 */
public class MsgCountVo implements Serializable {
    private static final long serialVersionUID = -1128331583103399933L;

    private Integer msgType;

    private Integer count = 0;

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
