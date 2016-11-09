package com.zyx.vo.zoom;

import com.zyx.entity.zoom.Circle;
import com.zyx.entity.zoom.CircleItem;
import com.zyx.vo.account.UserIconVo;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.zoom.dto
 * Create by XiaoWei on 2016/8/15
 */
public class CircleItemLunBoVo extends CircleItem {
    private UserIconVo userIconVo;
    private String tjImgae_url;
    private Circle circleVo;
    UserAuthVo userAuthVo;

    public String getTjImgae_url() {
        return tjImgae_url;
    }

    public void setTjImgae_url(String tjImgae_url) {
        this.tjImgae_url = tjImgae_url;
    }

    public UserIconVo getUserIconVo() {
        return userIconVo;
    }

    public void setUserIconVo(UserIconVo userIconVo) {
        this.userIconVo = userIconVo;
    }

    public Circle getCircleVo() {
        return circleVo;
    }

    public void setCircleVo(Circle circleVo) {
        this.circleVo = circleVo;
    }

    public UserAuthVo getUserAuthVo() {
        return userAuthVo;
    }

    public void setUserAuthVo(UserAuthVo userAuthVo) {
        this.userAuthVo = userAuthVo;
    }
}
