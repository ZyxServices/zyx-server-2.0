package com.zyx.service.record.impl;

import com.zyx.entity.record.Footprint;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.record.FootprintService;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/11/4.
 */
@Service("footprintService")
public class FootprintServiceImpl extends BaseServiceImpl<Footprint> implements FootprintService {
    public FootprintServiceImpl() {
        super(Footprint.class);
    }
}
