package com.zyx.rpc.venue.impl;

import com.zyx.entity.venue.Venue;
import com.zyx.param.venue.VenueParam;
import com.zyx.rpc.venue.VenueFacade;
import com.zyx.service.venue.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrDeng on 2016/11/10.
 */
@Service("venueFacade")
public class VenueFacadeImpl implements VenueFacade {
    @Autowired
    VenueService venueService;
    @Override
    public void uploadVenue(Venue venue) {
        venueService.save(venue);
    }

    @Override
    public List<Venue> getVenues(VenueParam param) {
        return venueService.getVenues(param);
    }
}
