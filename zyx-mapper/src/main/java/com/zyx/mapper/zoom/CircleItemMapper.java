package com.zyx.mapper.zoom;

import com.zyx.entity.zoom.CircleItem;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.zoom.CircleItemLunBoVo;
import com.zyx.vo.zoom.CircleItemVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.zoom
 * Create by XiaoWei on 2016/6/21
 */
@Repository("circleItemMapper")
public interface CircleItemMapper extends BaseMapper<CircleItem> {
    List<CircleItemVo> circleItemList(@Param(value = "circleId") Integer circleId, @Param("start") Integer start, @Param("end") Integer pageSize);

    int getCircleItemCounts(@Param(value = "circleId") Integer circleId);

    Integer setTop(@Param("top") Integer topSize, @Param("circleItemId") Integer circleItemId);

    List<CircleItem> topList(@Param("circleId") Integer circleId, @Param("max") Integer max);

    CircleItem findById(@Param("circleItemId") Integer circleItemId);

    Integer delByThisUser(@Param("createThisId") Integer createThisId, @Param("circleItemId") Integer circleItemId);

    List<CircleItemLunBoVo> getLunBo(@Param("max") Integer max);

    CircleItemLunBoVo getOneCircleItem(@Param("id") Integer id);

    List<CircleItemVo> getTjCircleItem(@Param("start") Integer start, @Param("end") Integer end);

    CircleItemVo selectCircleItemById(Integer id);

    List<CircleItemVo> selectCircleItemByIds(@Param("ids") List<Integer> ids);

}
