package com.zyx.rpc.user;

import com.zyx.param.attention.AttentionParam;

import java.util.Map;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
public interface MyAttentionFacade {
    Map<String, Object> myFSList(AttentionParam attentionParam);

    Map<String, Object> myGZList(AttentionParam attentionParam);

    /**
     * 我的关注大咖列表
     */
    Map<String, Object> myDKGZList(AttentionParam attentionParam);
}
