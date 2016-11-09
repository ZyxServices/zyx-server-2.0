package com.zyx.service.zoom.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.zoom.Follow;
import com.zyx.mapper.zoom.FollowMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.zoom.FollowService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom.impl
 * Create by XiaoWei on 2016/11/9
 */
@Service
public class FollowServiceImpl extends BaseServiceImpl<Follow> implements FollowService {
    public FollowServiceImpl() {
        super(Follow.class);
    }

    @Resource
    private FollowMapper followMapper;

    @Override
    public Map<String, Object> addFollow(Integer fromUserId, Integer toUserId) {
        Follow f=new Follow();
        f.setFormUserId(fromUserId);
        f.setToUserId(toUserId);
        f.setCreateTime(new Date().getTime());
        Integer result=followMapper.insert(f);
        if(result>0){
            return MapUtils.buildSuccessMap(Constants.SUCCESS,Constants.SUCCESS_MSG,result);
        }
        return ZoomConstants.MAP_500;
    }
}
