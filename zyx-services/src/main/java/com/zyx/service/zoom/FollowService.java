package com.zyx.service.zoom;

import com.zyx.entity.zoom.Follow;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom
 * Create by XiaoWei on 2016/11/9
 */
public interface FollowService extends BaseService<Follow> {
    Map<String, Object> addFollow(Integer fromUserId, Integer toUserId);
}
