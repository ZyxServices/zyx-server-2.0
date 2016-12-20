package com.zyx.service.zoom.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.zoom.Equip;
import com.zyx.mapper.zoom.EquipMapper;
import com.zyx.param.user.UserEquipmentParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.zoom.EquipService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.zoom.EquipDetailsVo;
import com.zyx.vo.zoom.EquipListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private EquipMapper equipMapper;


    @Override
    public Map<String, Object> addEquip(String title, String content, Integer accountId, Integer labelId, String imgUrls) {
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

        Equip e = new Equip();
        e.setCreateTime(new Date().getTime());
        e.setTitle(title);
        e.setAccountId(accountId);
        e.setContent(content);
        e.setEquipType(0);
        e.setLabelId(labelId);
        e.setMask(0);
        e.setDel(0);
        e.setImgUrl(imgUrls);
        Integer result = save(e);
        if (result > 0) {
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.SUCCESS_MSG, null);
        }
        return ZoomConstants.MAP_500;
    }

    @Override
    public Map<String, Object> queryEquip(Integer eId) {

        return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, equipMapper.queryEquip(eId));
    }

    @Override
    public Map<String, Object> queryOne(Integer eId) {
        if (Objects.equals(eId, null)) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30009, ZoomConstants.PG_ERROR_CODE_30009_MSG);
        }
        EquipDetailsVo detailsVos = equipMapper.queryOne(eId);
        return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.SUCCESS_MSG, detailsVos);
    }

    @Override
    public Map<String, Object> queryMyList(UserEquipmentParam userEquipmentParam) {
        if (Objects.equals(userEquipmentParam.getUserId(), null)) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30009, ZoomConstants.PG_ERROR_CODE_30009_MSG);
        }
        List<EquipDetailsVo> list = equipMapper.queryMyList(userEquipmentParam);
        return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.SUCCESS_MSG, list);
    }

    @Override
    public Map<String, Object> queryByLabelId(Integer tagId, Integer loginUserId, Integer start, Integer pageSize) {
        try {
            start = Optional.ofNullable(start).orElse(1);
            pageSize = Optional.ofNullable(pageSize).orElse(10);
            List<EquipListVo> equipListVos = equipMapper.queryByLabelId(tagId, loginUserId, (start - 1) * pageSize, pageSize);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, equipListVos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
