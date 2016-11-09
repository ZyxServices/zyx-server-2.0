package com.zyx.service.venue.impl;

import java.util.List;
import com.zyx.entity.venue.Venue;
import com.zyx.mapper.venue.VenueMapper;
import com.zyx.param.venue.VenueParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.venue.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    @Override
//    public List<Venue> getUserFpVenus(Integer userId) {
//        return venueMapper.selectUserFpVenus(userId);
//    }

//    @Override
//    public Integer countUserFpCity(Integer userId) {
//        return venueMapper.countUserFpCity(userId);
//    }
}
