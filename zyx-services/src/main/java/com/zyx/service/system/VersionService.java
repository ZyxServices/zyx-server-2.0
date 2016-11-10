package com.zyx.service.system;

import  java.util.List;
import com.zyx.entity.system.Version;
import com.zyx.service.BaseService;

/**
 * Created by MrDeng on 2016/11/10.
 */
public interface VersionService extends BaseService<Version> {
    Version getNewVersion(Integer type, Integer platform);
    List<Version> getHistoryVersion(Integer type,Integer platform);
}
