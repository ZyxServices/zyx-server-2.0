package com.zyx.service.system.impl;

import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.system.Reply;
import com.zyx.mapper.system.ReplyMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.system.ReplyService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.pg.impl
 * Create by XiaoWei on 2016/6/27
 */
@Service("replyService")
public class ReplyServiceImpl extends BaseServiceImpl<Reply> implements ReplyService {
    public ReplyServiceImpl() {
        super(Reply.class);
    }

    @Resource
    private ReplyMapper replyMapper;

    @Override
    public Map<String, Object> addReply(Integer replyParentId, Integer replyFromUser, Integer replyToUser, String replyContent, String replyImgPath) {
        Map<String, Object> resultMap = new HashMap<>();
        Reply reply = new Reply();
        try {
            if (replyParentId == null) {
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30037, ZoomConstants.PG_ERROR_CODE_30037_MSG);
            }
            if (replyFromUser == null) {
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30038, ZoomConstants.PG_ERROR_CODE_30038_MSG);
            }
            if (replyToUser == null) {
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30039, ZoomConstants.PG_ERROR_CODE_30039_MSG);
            }
            if (replyContent == null) {
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30010, ZoomConstants.PG_ERROR_CODE_30010_MSG);
            }
            reply.setReplyParentId(replyParentId);
            reply.setReplyFromUser(replyFromUser);
            reply.setReplyToUser(replyToUser);
            reply.setReplyContent(replyContent);
            reply.setCreateTime(new Date().getTime());
            reply.setReplyState(0);
            reply.setReplyImgPath(replyImgPath);
            mapper.insert(reply);
//            resultMap.put(ZoomConstants.STATE, ZoomConstants.SUCCESS);
//            resultMap.put(ZoomConstants.SUCCESS_MSG, ZoomConstants.MSG_SUCCESS);
//            return resultMap;
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_33000_MSG, null);

        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> delReply(Integer id, Integer replyAccountId) {
        if (Objects.equals(id, null)) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30019, ZoomConstants.PG_ERROR_CODE_30019_MSG);
        }
        if (Objects.equals(replyAccountId, null)) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30036, ZoomConstants.PG_ERROR_CODE_30036_MSG);
        }
        Integer result = replyMapper.delReply(id, replyAccountId);
        if (result > 0) {
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.SUCCESS_MSG, null);
        }
        return ZoomConstants.MAP_500;
    }
}
