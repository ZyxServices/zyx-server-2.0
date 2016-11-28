package com.zyx.rpc.venue.impl;

import com.alibaba.fastjson.JSONObject;
import com.zyx.constants.Constants;
import com.zyx.entity.venue.Venue;
import com.zyx.param.venue.FindVenueParam;
import com.zyx.param.venue.VenueParam;
import com.zyx.rpc.venue.VenueFacade;
import com.zyx.service.venue.VenueService;
import com.zyx.utils.MapUtils;
import com.zyx.utils.VerificationUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by MrDeng on 2016/11/10.
 */
@Service("venueFacade")
public class VenueFacadeImpl implements VenueFacade {
    @Autowired
    VenueService venueService;

    @Resource
    protected RedisTemplate<String, String> stringRedisTemplate;
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
            String keyHash = "_" + param.getPageNumber() + param.getNumber();
            Object sValue = stringRedisTemplate.opsForHash().get(Constants.VENUE_REDIS_List_KEY, keyHash);
            if (sValue == null) {
                Map<String, Object> map = venueService.findVenue(param);
                if (VerificationUtils.dataSuccessAndDataNotNull(map)) {
                    if (map.get(Constants.DATA) != null && !map.get(Constants.DATA).equals("null") && !map.get(Constants.DATA).equals("")) {
                        String toString = JSONObject.toJSON(map.get(Constants.DATA)).toString();
                        stringRedisTemplate.opsForHash().put(Constants.VENUE_REDIS_List_KEY, "_" + param.getPageNumber() + param.getNumber(), toString);
                        stringRedisTemplate.expire(Constants.VENUE_REDIS_List_KEY, 2 * 60, TimeUnit.SECONDS);
                    }
                }
                return map;
            } else {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.MSG_SUCCESS, sValue);
            }
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
