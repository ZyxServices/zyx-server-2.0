package com.zyx.rpc.zoom;

import com.zyx.service.zoom.FollowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.rpc.zoom
 * Create by XiaoWei on 2016/11/9
 */
@Service("zoomFacade")
public class ZoomFacadeImpl implements ZoomFacade {

    @Resource
    private FollowService followService;

    @Override
    public Map<String, Object> addFollow(Integer fromUserId, Integer toUserId) {
        return followService.addFollow(fromUserId, toUserId);
    }
}
