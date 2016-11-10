package com.zyx.mapper.system;

import com.zyx.entity.system.Version;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by MrDeng on 2016/11/10.
 */
@Repository("versionMapper")
public interface VersionMapper extends BaseMapper<Version> {
}
