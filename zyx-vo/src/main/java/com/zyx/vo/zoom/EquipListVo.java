package com.zyx.vo.zoom;

import com.zyx.entity.zoom.Equip;
import com.zyx.entity.zoom.EquipLabel;
import com.zyx.vo.account.UserIconVo;

import java.io.Serializable;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.zoom
 * Create by XiaoWei on 2016/11/21
 */
public class EquipListVo extends Equip implements Serializable {
    private Integer commentCounts;
    private Integer zanCounts;
    private UserIconVo userIconVo;
    private UserAuthVo userAuthVo;
    private String labelName;

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

    public UserAuthVo getUserAuthVo() {
        return userAuthVo;
    }

    public void setUserAuthVo(UserAuthVo userAuthVo) {
        this.userAuthVo = userAuthVo;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
