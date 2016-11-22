package com.zyx.mapper.zoom;

import com.zyx.entity.zoom.Equip;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.zoom.EquipDetailsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.zoom
 * Create by XiaoWei on 2016/11/17
 */
@Repository("equipMapper")
public interface EquipMapper extends BaseMapper<Equip> {

    List<Equip> queryEquip(@Param("id") Integer id);

    EquipDetailsVo queryOne(@Param("id") Integer id);

}
