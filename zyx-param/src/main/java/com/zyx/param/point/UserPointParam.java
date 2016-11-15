package com.zyx.param.point;

import com.zyx.param.BaseParam;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
public class UserPointParam extends BaseParam {

    private static final long serialVersionUID = -2078723475824179207L;
    private Integer id;

    private Integer userId;

    private Long modifyTime;

    private Long createTime;

    private Integer pointType;

    private Long pointCount;

    /**
     * 积分记录的表名
     */
    private String detailTable;

    /**
     * 积分记录的type
     */
    private Integer detailType;

    /**
     * 积分记录的详细信息
     */
    private String detailMsg;

    private UserPointRuleParam ruleParam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getPointType() {
        return pointType;
    }

    public void setPointType(Integer pointType) {
        this.pointType = pointType;
    }

    public Long getPointCount() {
        return pointCount;
    }

    public void setPointCount(Long pointCount) {
        this.pointCount = pointCount;
    }

    public String getDetailTable() {
        return detailTable;
    }

    public void setDetailTable(String detailTable) {
        this.detailTable = detailTable;
    }

    public Integer getDetailType() {
        return detailType;
    }

    public void setDetailType(Integer detailType) {
        this.detailType = detailType;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public UserPointRuleParam getRuleParam() {
        return ruleParam;
    }

    public void setRuleParam(UserPointRuleParam ruleParam) {
        this.ruleParam = ruleParam;
    }
}
