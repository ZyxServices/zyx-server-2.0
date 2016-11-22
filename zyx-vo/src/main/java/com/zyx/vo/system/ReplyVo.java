package com.zyx.vo.system;

import com.zyx.entity.system.Reply;
import com.zyx.vo.account.UserIconVo;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.pg
 * Create by XiaoWei on 2016/9/6
 */
public class ReplyVo extends Reply {
    private UserIconVo fromUserVo;
    private UserIconVo toUserVo;

    public UserIconVo getFromUserVo() {
        return fromUserVo;
    }

    public void setFromUserVo(UserIconVo fromUserVo) {
        this.fromUserVo = fromUserVo;
    }

    public UserIconVo getToUserVo() {
        return toUserVo;
    }

    public void setToUserVo(UserIconVo toUserVo) {
        this.toUserVo = toUserVo;
    }
}
