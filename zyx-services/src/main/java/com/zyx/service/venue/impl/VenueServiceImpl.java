package com.zyx.service.venue.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.venue.Venue;
import com.zyx.mapper.venue.VenueMapper;
import com.zyx.param.venue.FindVenueParam;
import com.zyx.param.venue.VenueParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.venue.VenueService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.venue.FindVenueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by MrDeng on 2016/11/7.
 */
@Service("venueService")
public class VenueServiceImpl extends BaseServiceImpl<Venue> implements VenueService {
    @Autowired
    VenueMapper venueMapper;

    public VenueServiceImpl() {
        super(Venue.class);
    }

    @Override
    public List<Venue> getVenues(VenueParam param) {
        return venueMapper.selectVenues(param);
    }

    @Override
    public Map<String, Object> findVenue(FindVenueParam param) {
        if (param.getType() != null && param.getNumber() != null && param.getPageNumber() != null) {
            if (param.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            param.setPageNumber((param.getPageNumber() - 1) * param.getNumber());
            List<FindVenueVo> findVenueVos = venueMapper.findVenues(param);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, findVenueVos);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> findVenueById(Integer id) {
        if (id != null && id > 0) {
            FindVenueVo byId = venueMapper.findVenueById(id);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, byId);
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

//    @Override
//    public List<Venue> getUserFpVenus(Integer userId) {
//        return venueMapper.selectUserFpVenus(userId);
//    }

//    @Override
//    public Integer countUserFpCity(Integer userId) {
//        return venueMapper.countUserFpCity(userId);
//    }
}
