package com.zyx.mapper.system;

import  java.util.List;
import com.zyx.entity.system.Version;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by MrDeng on 2016/11/10.
 */
@Repository("versionMapper")
public interface VersionMapper extends BaseMapper<Version> {
    Version selectNewVersion(@Param("type")Integer type,@Param("platform") Integer platform);
    List<Version> selectHistoryVersion(@Param("type")Integer type, @Param("platform")Integer platform);
}
