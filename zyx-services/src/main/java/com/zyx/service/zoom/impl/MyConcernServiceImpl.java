package com.zyx.service.zoom.impl;

import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.zoom.MyConcern;
import com.zyx.mapper.zoom.MyConcernMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.zoom.MyConcernService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom.impl
 * Create by XiaoWei on 2016/6/20
 */
@Service
public class MyConcernServiceImpl extends BaseServiceImpl<MyConcern> implements MyConcernService {

    public MyConcernServiceImpl() {
        super(MyConcern.class);
    }

    @Resource
    MyConcernMapper myConcernMapper;

    @Override
    public Map<String, Object> addMyConcern(Integer concernId, Integer concern_type, Integer accountId) {
        Map<String, Object> map = new HashMap<>();
        try {
            MyConcern myConcern = new MyConcern();
            if (concernId == null) {
//                map.put(ZoomConstants.STATE, ZoomConstants.PG_ERROR_CODE_30015);
//                map.put(ZoomConstants.ERROR_MSG, ZoomConstants.PG_ERROR_CODE_30015_MSG);
//                return map;
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30015, ZoomConstants.PG_ERROR_CODE_30015_MSG);

            }
            Optional.ofNullable(concernId).ifPresent(myConcern::setConcernId);
            if (concern_type == null) {
//                map.put(ZoomConstants.STATE, ZoomConstants.PG_ERROR_CODE_30016);
//                map.put(ZoomConstants.ERROR_MSG, ZoomConstants.PG_ERROR_CODE_30016_MSG);
//                return map;
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30016, ZoomConstants.PG_ERROR_CODE_30016_MSG);

            }
            Optional.ofNullable(concern_type).ifPresent(myConcern::setConcernType);
            if (accountId == null) {
//                map.put(ZoomConstants.STATE, ZoomConstants.PG_ERROR_CODE_30014);
//                map.put(ZoomConstants.ERROR_MSG, ZoomConstants.PG_ERROR_CODE_30014_MSG);
//                return map;
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30014, ZoomConstants.PG_ERROR_CODE_30014_MSG);

            }
            Optional.ofNullable(accountId).ifPresent(myConcern::setAccountId);
            myConcern.setCreateTime(new Date().getTime());
            MyConcern myConcernFind = myConcernMapper.existConcern(accountId, concernId, concern_type);
            if (myConcernFind != null) {
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30028, ZoomConstants.PG_ERROR_CODE_30028_MSG);
            }
            save(myConcern);
//            map.put(ZoomConstants.STATE, ZoomConstants.SUCCESS);
//            map.put(ZoomConstants.SUCCESS_MSG, ZoomConstants.MSG_SUCCESS);
//            return map;
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_33000_MSG, null);
        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> findByParams(Integer concernId, Integer concernType,String keyWord) {
        if (concernId == null) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30015, ZoomConstants.PG_ERROR_CODE_30015_MSG);
        }
        if (concernType == null) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30016, ZoomConstants.PG_ERROR_CODE_30016_MSG);
        }

        return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_34000_MSG, myConcernMapper.findByParams(concernId, concernType,keyWord));
    }

    @Override
    public Map<String, Object> delMyConcern(Integer circleId, Integer accountId) {
        MyConcern myConcernFind = myConcernMapper.existConcern(accountId, circleId, 4);
        if (myConcernFind != null) {
            if (Objects.equals(accountId, myConcernFind.getAccountId())) {
                Integer result = myConcernMapper.delMyConcern(myConcernFind.getId());
                if (result > 0) {
                  return  MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_39000_MSG, null);
                }
            } else {
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30029, ZoomConstants.PG_ERROR_CODE_30029_MSG);
            }
        } else {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30031, ZoomConstants.PG_ERROR_CODE_30031_MSG);
        }
        return ZoomConstants.MAP_500;
    }
}
