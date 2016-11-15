package com.zyx.vo.account;

import com.zyx.vo.point.UserPointVo;

import java.io.Serializable;

/**
 * Created by wms on 2016/11/7.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/7
 */
public class AccountAttentionVo implements Serializable {

    private static final long serialVersionUID = -7705607146090808678L;

    private Integer id;

    private String nickname;

    private String avatar;

    private String authInfo;

    private UserPointVo level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }

    public UserPointVo getLevel() {
        return level;
    }

    public void setLevel(UserPointVo level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "AccountAttentionVo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", authInfo='" + authInfo + '\'' +
                '}';
    }
}
