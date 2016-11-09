package com.zyx.mapper.zoom;

import com.zyx.entity.zoom.Follow;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.zoom
 * Create by XiaoWei on 2016/11/9
 */
@Repository("followMapper")
public interface FollowMapper extends BaseMapper<Follow> {
//    Integer addFollow(@Param("fromUserId") Integer fromUserId, @Param("toUserId") Integer toUserId);
}
