package com.zyx.mapper.system;

import com.zyx.entity.system.Reply;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.zoom
 * Create by XiaoWei on 2016/6/27
 */
@Repository("replyMapper")
public interface ReplyMapper extends BaseMapper<Reply> {

    int delReply(@Param("id") Integer id, @Param("reply_account_id") Integer replyAccountId);

}
