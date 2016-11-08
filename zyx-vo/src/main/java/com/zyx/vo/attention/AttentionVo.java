package com.zyx.vo.attention;

import com.zyx.vo.account.AccountAttentionVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
public class AttentionVo implements Serializable {

    private static final long serialVersionUID = -5301560563920535610L;
    
    private Integer id;

    private List<AccountAttentionVo> attentions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<AccountAttentionVo> getAttentions() {
        return attentions;
    }

    public void setAttentions(List<AccountAttentionVo> attentions) {
        this.attentions = attentions;
    }
}
