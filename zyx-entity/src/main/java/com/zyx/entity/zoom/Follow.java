package com.zyx.entity.zoom;

import com.zyx.entity.BaseEntity;

import javax.persistence.Table;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.zoom
 * Create by XiaoWei on 2016/11/7
 */
@Table(name = "follow")
public class Follow extends BaseEntity {
    private int formUserId;
    private int toUserId;

    public int getFormUserId() {
        return formUserId;
    }

    public void setFormUserId(int formUserId) {
        this.formUserId = formUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }
}
