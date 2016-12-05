package com.zyx.entity.user;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by wms on 2016/12/5.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/12/5
 */
@Table(name = "user_suggestion")
public class UserSuggestionInfo extends BaseEntity {

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer userId;

    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String content;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
