package com.zyx.service.system;

import com.zyx.entity.account.UserMsgInfo;
import com.zyx.param.account.UserMsgParam;
import com.zyx.service.BaseService;
import com.zyx.vo.account.MsgVo;

import java.util.List;

/**
 * Created by wms on 2016/11/15.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/15.
 */
public interface UserMsgService extends BaseService<UserMsgInfo> {
    Long queryMsgCount(UserMsgParam userMsgParam);

    List<MsgVo> queryMsgList(UserMsgParam userMsgParam);

    int deleteMsg(UserMsgParam userMsgParam);
}
