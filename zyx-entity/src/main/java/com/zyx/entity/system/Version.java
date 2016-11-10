package com.zyx.entity.system;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * Created by MrDeng on 2016/11/10.
 */
@Table(name="t_version")
public class Version extends BaseEntity{

    /**
     * 版本类型
     * 1-正式发布版 2-内测版本 3-公测版本
     */
    private Integer type;
    /**
     *发布日期
     */
    private Long publishTime;
    /**
     * 平台种类
     *1-Android 2-IOS
     */
    private Integer platform;
    /**
     * 版本号
     */
    private String version;
    /**
     * 下载地址
     */
    private String downloadUrl;
    /**
     * 版本状态
     * 1-最新版本 -1-停用版本 2-过期版本
     */
    private Integer state;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
