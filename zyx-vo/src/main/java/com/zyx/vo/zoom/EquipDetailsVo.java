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
    private Integer commentCounts = 0;
    private Integer zanCounts = 0;
    private UserIconVo userIconVo;
    private String labelName;
    private List<CommentVo> commentVos;

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }

    public Integer getZanCounts() {
        return zanCounts;
    }

    public void setZanCounts(Integer zanCounts) {
        this.zanCounts = zanCounts;
    }

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
