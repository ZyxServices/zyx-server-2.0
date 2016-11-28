package com.zyx.vo.account;

import com.zyx.vo.point.UserPointVo;

import java.io.Serializable;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.zoom.dto
 * Create by XiaoWei on 2016/8/16
 * <p>
 * 注：用户头像信息
 */
public class UserIconVo implements Serializable {
    private Integer id;
    private String nickName;
    private String avatar;
    private Integer authenticate;

    private UserPointVo level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getAuthenticate() {
        return authenticate;
    }

    public void setAuthenticate(Integer authenticate) {
        this.authenticate = authenticate;
    }

    public UserPointVo getLevel() {
        return level;
    }

    public void setLevel(UserPointVo level) {
        this.level = level;
    }
}
