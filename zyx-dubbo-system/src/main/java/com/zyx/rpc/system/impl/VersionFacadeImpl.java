package com.zyx.rpc.system.impl;

import com.zyx.entity.system.Version;
import com.zyx.rpc.system.VersionFacade;
import com.zyx.service.system.VersionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by MrDeng on 2016/11/10.
 */
public class VersionFacadeImpl implements VersionFacade {
    @Autowired
    VersionService versionService;
    @Override
    public Version getNewVersion() {
        return null;
    }
}
