package com.zyx.mapper.zoom;

import com.zyx.entity.zoom.CircleType;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.zoom
 * Create by XiaoWei on 2016/8/25
 */

@Repository("circleTypeMapper")
public interface CircleTypeMapper extends BaseMapper<CircleType> {
    List<CircleType> getList();
}
