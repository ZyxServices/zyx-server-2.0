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
public class MyCenterInfoVo implements Serializable {
    private static final long serialVersionUID = -8232637143152445582L;

    private Integer id;

    private String phone;

    private String nickname;

    private Integer sex;

    private String avatar;

    private String address;

    private long birthday;

    /**
     * 是否认证字段0未认证，1待审核，2已认证，3认证失败
     */
//    private Integer authenticate;

    /**
     * 签名
     */
    private String signature = "";

    /**
     * 关注数量
     */
    private Integer gz = 0;

    /**
     * 粉丝数量
     */
    private Integer fs = 0;

    /**
     * 动态数量
     */
    private Integer dt = 0;

    /**
     * 运动币
     */
    private Integer coin = 0;

//    private AccountAuthVo accountAuth;

    private UserPointVo level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getGz() {
        return gz;
    }

    public void setGz(Integer gz) {
        this.gz = gz;
    }

    public Integer getFs() {
        return fs;
    }

    public void setFs(Integer fs) {
        this.fs = fs;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public UserPointVo getLevel() {
        return level;
    }

    public void setLevel(UserPointVo level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "MyCenterInfoVo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", signature='" + signature + '\'' +
                ", gz=" + gz +
                ", fs=" + fs +
                ", dt=" + dt +
                '}';
    }
}
