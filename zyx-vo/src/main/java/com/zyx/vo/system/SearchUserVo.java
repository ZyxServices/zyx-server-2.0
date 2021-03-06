package com.zyx.vo.system;

import com.zyx.vo.point.UserPointVo;

import java.io.Serializable;

/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/16
 */
public class SearchUserVo implements Serializable {

    private Integer id;

    private String avatar;

    private String nickname;

    private UserPointVo level;

    private boolean toFollowers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserPointVo getLevel() {
        return level;
    }

    public void setLevel(UserPointVo level) {
        this.level = level;
    }

    public boolean isToFollowers() {
        return toFollowers;
    }

    public void setToFollowers(int toFollowers) {
        if(toFollowers <= 0){
            this.toFollowers = false;
        }else{
            this.toFollowers = true;
        }
    }
}
