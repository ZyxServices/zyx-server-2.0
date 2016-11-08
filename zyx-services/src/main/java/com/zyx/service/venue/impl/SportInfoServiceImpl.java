package com.zyx.service.venue.impl;

import com.zyx.entity.venue.SportInfo;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.venue.SportInfoService;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/11/4.
 */
@Service("sportInfoService")
public class SportInfoServiceImpl extends BaseServiceImpl<SportInfo> implements SportInfoService {
    public SportInfoServiceImpl() {
        super(SportInfo.class);
    }
}
