package com.zyx.service.zoom.impl;

import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.system.Zan;
import com.zyx.mapper.system.ZanMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.zoom.ZanService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.system.ZanCountVo;
import com.zyx.vo.system.ZanVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom.impl
 * Create by XiaoWei on 2016/6/17
 */
@Service
public class ZanServiceImpl extends BaseServiceImpl<Zan> implements ZanService {
    @Autowired
    ZanMapper zanMapper;

    public ZanServiceImpl() {
        super(Zan.class);
    }

    @Override
    public Map<String, Object> addZan(Integer body_id, Integer body_type, Integer account_id) {
        Map<String, Object> map = new HashMap<>();
        try {
            Zan zan = new Zan();
            if (body_id == null) {
//                map.put(ZoomConstants.STATE, ZoomConstants.PG_ERROR_CODE_30009);
//                map.put(ZoomConstants.ERROR_MSG, ZoomConstants.PG_ERROR_CODE_30009_MSG);
//                return map;
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30009, ZoomConstants.PG_ERROR_CODE_30009_MSG);

            }
            Optional.ofNullable(body_id).ifPresent(zan::setBodyId);
            if (body_type == null) {
//                map.put(ZoomConstants.STATE, ZoomConstants.PG_ERROR_CODE_30017);
//                map.put(ZoomConstants.ERROR_MSG, ZoomConstants.PG_ERROR_CODE_30017_MSG);
//                return map;
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30017, ZoomConstants.PG_ERROR_CODE_30017_MSG);

            }
            Optional.ofNullable(body_type).ifPresent(zan::setBodyType);
            if (account_id == null) {
//                map.put(ZoomConstants.STATE, ZoomConstants.PG_ERROR_CODE_30014);
//                map.put(ZoomConstants.ERROR_MSG, ZoomConstants.PG_ERROR_CODE_30014_MSG);
//                return map;
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30014, ZoomConstants.PG_ERROR_CODE_30014_MSG);

            }
            Optional.ofNullable(account_id).ifPresent(zan::setAccountId);
            Integer result = zanMapper.exist(body_id, body_type, account_id);
            if (Objects.equals(result, 0)) {
                save(zan);
                return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_33000_MSG, null);
            } else {
                Integer deleteResult = zanMapper.cancelZan(body_id, body_type, account_id);
                if (deleteResult > 0)
                    return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_30040_MSG, null);
                else
                    return ZoomConstants.MAP_500;
            }
//            map.put(ZoomConstants.STATE, ZoomConstants.SUCCESS);
//            map.put(ZoomConstants.SUCCESS_MSG, ZoomConstants.MSG_SUCCESS);
//            return map;


        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }
    }

    @Override
    public List<ZanCountVo> countZanByBodyId(Integer type, List<Integer> bodyIds) {
        ZanVo vo = new ZanVo();
        vo.setType(type);
        vo.setBodyIds(bodyIds);
        return zanMapper.countZanByBodyId(vo);
    }

    @Override
    public ZanCountVo countZanByBodyId(Integer type, Integer bodyId) {
        Zan record = new Zan();
        record.setBodyType(type);
        record.setBodyId(bodyId);
        ZanCountVo dto = new ZanCountVo();
        dto.setBodyId(bodyId);
        dto.setBodyType(type);
        dto.setZanCount(selectCount(record));
        return dto;
    }
}
