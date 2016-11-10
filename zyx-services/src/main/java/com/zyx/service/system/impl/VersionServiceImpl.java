package com.zyx.service.system.impl;

import com.zyx.entity.system.Version;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.system.VersionService;

/**
 * Created by MrDeng on 2016/11/10.
 */
public class VersionServiceImpl extends BaseServiceImpl<Version> implements VersionService {
    public VersionServiceImpl() {
        super(Version.class);
    }
}
