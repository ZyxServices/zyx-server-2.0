package com.zyx.mapper.system;

import com.zyx.entity.account.UserMsgInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.account.UserMsgParam;
import com.zyx.vo.account.MsgCountVo;
import com.zyx.vo.account.MsgVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wms on 2016/11/15.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/15.
 */
@Repository("userMsgMapper")
public interface UserMsgMapper extends BaseMapper<UserMsgInfo> {
    List<MsgCountVo> queryMsgCount(UserMsgParam userMsgParam);

    List<MsgVo> queryMsgList(UserMsgParam userMsgParam);

    int deleteMsg(UserMsgParam userMsgParam);

    int setMsgState(UserMsgParam userMsgParam);
}
