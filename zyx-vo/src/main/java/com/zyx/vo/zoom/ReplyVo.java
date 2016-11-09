package com.zyx.vo.zoom;

import com.zyx.entity.system.Reply;
import com.zyx.vo.account.UserIconVo;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.zoom
 * Create by XiaoWei on 2016/9/6
 */
public class ReplyVo extends Reply {
    private UserIconVo fromUserIconVo;
    private UserIconVo toUserIconVo;

    public UserIconVo getFromUserIconVo() {
        return fromUserIconVo;
    }

    public void setFromUserIconVo(UserIconVo fromUserIconVo) {
        this.fromUserIconVo = fromUserIconVo;
    }

    public UserIconVo getToUserIconVo() {
        return toUserIconVo;
    }

    public void setToUserIconVo(UserIconVo toUserIconVo) {
        this.toUserIconVo = toUserIconVo;
    }
}
