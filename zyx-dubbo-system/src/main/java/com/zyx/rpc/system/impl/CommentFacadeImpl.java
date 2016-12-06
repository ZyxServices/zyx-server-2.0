package com.zyx.rpc.system.impl;

import com.zyx.constants.coin.CoinConstants;
import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.rpc.system.CommentFacade;
import com.zyx.service.coin.SportCoinService;
import com.zyx.service.system.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.rpc.system.impl
 * Create by XiaoWei on 2016/8/29
 */
@Service("commentFacade")
public class CommentFacadeImpl implements CommentFacade {
    @Resource
    private CommentService commentService;
    @Resource
    SportCoinService sportCoinService;

    @Override
    public Map<String, Object> addComment(Integer commentType, Integer commentId, String commentContent, Integer commentAccount, Integer commentState, String commentImgPath) {

        Map map = commentService.addComment(commentType, commentId, commentContent, commentAccount, commentState, commentImgPath);
        if (null != map && !map.isEmpty() && map.get(ZoomConstants.STATE).equals(ZoomConstants.SUCCESS))
            sportCoinService.modifyCoin(commentAccount, CoinConstants.OperType.PUBLISH_COMMENT);
        return map;
    }

    @Override
    public Map<String, Object> queryComment(Integer commentType, Integer commentId) {
        return commentService.queryComment(commentType, commentId);
    }

    @Override
    public Map<String, Object> delComment(Integer id, Integer comment_accountId) {
        return commentService.delComment(id, comment_accountId);
    }
}
