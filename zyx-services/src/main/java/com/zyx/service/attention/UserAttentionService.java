package com.zyx.service.attention;

import com.zyx.entity.attention.UserAttention;
import com.zyx.param.attention.AttentionParam;
import com.zyx.service.BaseService;
import com.zyx.vo.attention.AttentionVo;

import java.util.List;

/**
 * Created by wms on 2016/11/8.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/8
 */
public interface UserAttentionService extends BaseService<UserAttention> {

    List<AttentionVo> myFSList(AttentionParam attentionParam);

    List<AttentionVo> myGZList(AttentionParam attentionParam);

    int selectAttentionCount(AttentionParam attentionParam);

    List<AttentionVo> myDKGZList(AttentionParam attentionParam);

    int deleteAttention(AttentionParam attentionParam);

    int addAttention(AttentionParam attentionParam);
}
