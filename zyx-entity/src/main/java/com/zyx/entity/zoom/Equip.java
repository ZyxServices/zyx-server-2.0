package com.zyx.entity.zoom;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.zoom
 * Create by XiaoWei on 2016/11/17
 */
@Table(name = "equip")
public class Equip extends BaseEntity {
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String title;
    @Column
    @ColumnType(jdbcType = JdbcType.LONGVARCHAR)
    private String content;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer accountId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer labelId;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer del;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer mask;
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer equipType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public Integer getEquipType() {
        return equipType;
    }

    public void setEquipType(Integer equipType) {
        this.equipType = equipType;
    }
}
