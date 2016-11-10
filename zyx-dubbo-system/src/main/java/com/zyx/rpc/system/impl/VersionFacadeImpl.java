package com.zyx.rpc.system.impl;

import  java.util.List;
import com.zyx.entity.system.Version;
import com.zyx.rpc.system.VersionFacade;
import com.zyx.service.system.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/11/10.
 */
@Service("versionFacade")
public class VersionFacadeImpl implements VersionFacade {
    @Autowired
    VersionService versionService;
    @Override
    public Version getNewVersion(Integer type, Integer platform) {
        return versionService.getNewVersion(type,platform);
    }

    @Override
    public List<Version> getHistoryVersion(Integer type, Integer platform) {
        return versionService.getHistoryVersion(type,platform);
    }
}
