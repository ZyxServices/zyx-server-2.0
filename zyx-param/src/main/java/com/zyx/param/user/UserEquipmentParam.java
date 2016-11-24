package com.zyx.param.user;

import com.zyx.param.BaseParam;

/**
 * Created by wms on 2016/11/24.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/24
 */
public class UserEquipmentParam extends BaseParam {
    private static final long serialVersionUID = -8530134886516256633L;

    private Integer userId;

    private Integer pageSize;

    private Integer page;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
