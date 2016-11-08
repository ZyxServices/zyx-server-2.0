package com.zyx.service.zoom.impl;

import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.zoom.Meet;
import com.zyx.entity.zoom.MyConcern;
import com.zyx.mapper.zoom.MeetMapper;
import com.zyx.mapper.zoom.MyConcernMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.zoom.MeetService;
import com.zyx.utils.DateUtils;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.zyx.constants.Constants.SUCCESS;
import static com.zyx.constants.zoom.ZoomConstants.*;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.zoom.impl
 * Create by XiaoWei on 2016/6/14
 */
@Service
public class MeetServiceImpl extends BaseServiceImpl<Meet> implements MeetService {
    public MeetServiceImpl() {
        super(Meet.class);
    }

    public static final int MODEL_CIRCLE = 4;

    @Resource
    private MeetMapper meetMapper;

    @Resource
    private MyConcernMapper myConcernMapper;

    @Override
    public Map<String, Object> addMeet(Integer circleId, Integer accountId) {
        Meet meet = new Meet();
        try {
            if (circleId == null) {
//                map.put(ZoomConstants.STATE, PG_ERROR_CODE_30001);
//                map.put(ZoomConstants.ERROR_MSG, PG_ERROR_CODE_30001_MSG);
//                return map;
                return MapUtils.buildErrorMap(PG_ERROR_CODE_30001, PG_ERROR_CODE_30001_MSG);
            }
            Optional.ofNullable(circleId).ifPresent(meet::setCircleId);
            if (accountId == null) {
//                map.put(ZoomConstants.STATE, ZoomConstants.PG_ERROR_CODE_30014);
//                map.put(ZoomConstants.ERROR_MSG, ZoomConstants.PG_ERROR_CODE_30014_MSG);
//                return map;
                return MapUtils.buildErrorMap(PG_ERROR_CODE_30014, PG_ERROR_CODE_30014_MSG);

            }
            MyConcern myConcernFind = myConcernMapper.existConcern(accountId, circleId, MODEL_CIRCLE);
            if (!Objects.equals(myConcernFind, null)) {
                Integer exist = meetMapper.existTodayMeet(accountId, circleId, DateUtils.setDateStart(0).getTime(), DateUtils.setDateEnd(0).getTime());
                if (Objects.equals(exist, 0)) {
                    Optional.ofNullable(accountId).ifPresent(meet::setAccountId);
                    meet.setCreateTime(new Date().getTime());
                    save(meet);
                    return MapUtils.buildSuccessMap(SUCCESS, PG_ERROR_CODE_33000_MSG, null);
                } else {
                    return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30028, PG_ERROR_CODE_30028_MSG);
                }
            }else{
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30041, PG_ERROR_CODE_30041_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }
    }
}
