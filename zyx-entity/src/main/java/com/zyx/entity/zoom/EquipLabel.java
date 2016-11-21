package com.zyx.entity.zoom;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.zoom
 * Create by XiaoWei on 2016/11/21
 */
@Table(name = "t_equip_label")
public class EquipLabel  extends BaseEntity{
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String labelName;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private String userId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer state;

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
