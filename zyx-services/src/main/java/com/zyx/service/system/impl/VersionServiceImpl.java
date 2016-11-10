package com.zyx.service.system.impl;
import  java.util.List;
import com.zyx.entity.system.Version;
import com.zyx.mapper.system.VersionMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.system.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/11/10.
 */
@Service("versionService")
public class VersionServiceImpl extends BaseServiceImpl<Version> implements VersionService {

    @Autowired
    VersionMapper versionMapper;
    public VersionServiceImpl() {
        super(Version.class);
    }

    @Override
    public Version getNewVersion(Integer type, Integer platform) {
        return versionMapper.selectNewVersion(type,platform);
    }

    @Override
    public List<Version> getHistoryVersion(Integer type, Integer platform) {
        return versionMapper.selectHistoryVersion(type,platform);
    }
}
