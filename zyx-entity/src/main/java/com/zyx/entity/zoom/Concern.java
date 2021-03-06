package com.zyx.entity.zoom;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by XiaoWei on 2016/6/3.
 */
@Table(name = "concern")
public class Concern extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer type;//2.0版本暂时未启用
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topicTitle;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String topicContent;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String imgUrl;
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String videoUrl;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer topicVisible;//0所有可见，1好友可见
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer state;//动态状态，-2未屏蔽，-1为删除

    @Column(name = "from_id")
    private Integer fromId;//跟fromType对应

    @Column(name = "from_type")
    private Integer fromType;//1:求约(活动)，2装备控，3记录。该字段只用于我的关注模块中自动生成的动态查询

    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String local;

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer appType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getTopicVisible() {
        return topicVisible;
    }

    public void setTopicVisible(Integer topicVisible) {
        this.topicVisible = topicVisible;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }
}
