package com.zyx.entity.zoom;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.*;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.zoom
 * Create by XiaoWei on 2016/11/7
 */
@Table(name = "follow")
public class Follow extends BaseEntity {
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private int fromUserId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private int toUserId;

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }
}
