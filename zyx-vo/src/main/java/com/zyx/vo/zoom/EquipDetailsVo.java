package com.zyx.vo.zoom;

import com.zyx.entity.zoom.Equip;
import com.zyx.vo.account.UserIconVo;
import com.zyx.vo.system.CommentVo;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.zoom
 * Create by XiaoWei on 2016/11/22
 */
public class EquipDetailsVo extends Equip {
    private UserIconVo userIconVo;
    private String labelName;
    private List<CommentVo> commentVos;

    public UserIconVo getUserIconVo() {
        return userIconVo;
    }

    public void setUserIconVo(UserIconVo userIconVo) {
        this.userIconVo = userIconVo;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public List<CommentVo> getCommentVos() {
        return commentVos;
    }

    public void setCommentVos(List<CommentVo> commentVos) {
        this.commentVos = commentVos;
    }
}
