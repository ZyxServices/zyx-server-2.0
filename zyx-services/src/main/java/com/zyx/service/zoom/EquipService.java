package com.zyx.service.zoom;

import com.zyx.entity.zoom.Equip;
import com.zyx.param.user.UserEquipmentParam;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom
 * Create by XiaoWei on 2016/11/17
 */
public interface EquipService extends BaseService<Equip> {
    Map<String, Object> addEquip(String title, String content, Integer accountId, Integer labelId,String imgUrls);

    Map<String, Object> queryEquip(Integer eId);

    Map<String, Object> queryOne(Integer eId);

    Map<String, Object> queryMyList(UserEquipmentParam userEquipmentParam);

    Map<String, Object> queryByLabelId(Integer tagId);
}
