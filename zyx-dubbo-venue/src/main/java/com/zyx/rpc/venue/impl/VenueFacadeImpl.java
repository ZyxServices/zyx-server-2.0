package com.zyx.rpc.venue.impl;

import com.zyx.constants.Constants;
import com.zyx.entity.venue.Venue;
import com.zyx.param.venue.FindVenueParam;
import com.zyx.param.venue.VenueParam;
import com.zyx.rpc.venue.VenueFacade;
import com.zyx.service.venue.VenueService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by MrDeng on 2016/11/10.
 */
@Service("venueFacade")
public class VenueFacadeImpl implements VenueFacade {
    @Autowired
    VenueService venueService;

    private static Logger logger = Logger.getLogger(VenueFacadeImpl.class);

    @Override
    public void uploadVenue(Venue venue) {
        venueService.save(venue);
    }

    @Override
    public List<Venue> getVenues(VenueParam param) {
        return venueService.getVenues(param);
    }

    @Override
    public Map<String, Object> findVenue(FindVenueParam param) {
        try {
            return venueService.findVenue(param);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> findVenueById(Integer id) {
        try {
            return venueService.findVenueById(id);
        } catch (Exception e) {
            logger.error(e);
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }
}
