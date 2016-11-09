package com.zyx.vo.zoom;



import com.zyx.entity.system.Comment;
import com.zyx.vo.account.UserIconVo;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.zoom
 * Create by XiaoWei on 2016/9/6
 */
public class CommentVo extends Comment {
    List<ReplyVo> replyVos;
    UserIconVo userIconVo;

    public List<ReplyVo> getReplyVos() {
        return replyVos;
    }

    public void setReplyVos(List<ReplyVo> replyVos) {
        this.replyVos = replyVos;
    }

    public UserIconVo getUserIconVo() {
        return userIconVo;
    }

    public void setUserIconVo(UserIconVo userIconVo) {
        this.userIconVo = userIconVo;
    }
}
