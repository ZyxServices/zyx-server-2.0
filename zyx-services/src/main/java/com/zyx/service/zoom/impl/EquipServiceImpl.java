package com.zyx.service.zoom.impl;

import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.zoom.Equip;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.zoom.EquipService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom.impl
 * Create by XiaoWei on 2016/11/17
 */
@Service
public class EquipServiceImpl extends BaseServiceImpl<Equip> implements EquipService {
    public EquipServiceImpl() {
        super(Equip.class);
    }


    @Override
    public Map<String, Object> addEquip(String title, String content, Integer accountId,Integer labelId) {
        if (Objects.equals(title, null) || Objects.equals(title, "")) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30006, ZoomConstants.PG_ERROR_CODE_30006_MSG);
        }
        if (Objects.equals(content, null) || Objects.equals(content, "")) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30007, ZoomConstants.PG_ERROR_CODE_30007_MSG);
        }
        if (Objects.equals(accountId, null)) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30014, ZoomConstants.PG_ERROR_CODE_30014_MSG);
        }
        if (Objects.equals(labelId, null)) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30027, ZoomConstants.PG_ERROR_CODE_30027_MSG);
        }

        Equip e=new Equip();
        e.setCreateTime(new Date().getTime());
        e.setTitle(title);
        e.setAccountId(accountId);
        e.setContent(content);
        e.setEquipType(0);
        e.setLabelId(labelId);
        Integer result=save(e);
        if(result>0){
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS,ZoomConstants.SUCCESS_MSG,null);
        }
        return ZoomConstants.MAP_500;
    }
}
