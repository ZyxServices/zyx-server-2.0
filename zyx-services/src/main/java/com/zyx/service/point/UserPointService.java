package com.zyx.service.point;

import com.zyx.entity.point.UserPointInfo;
import com.zyx.param.point.UserPointParam;
import com.zyx.service.BaseService;
import com.zyx.vo.point.UserPointVo;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
public interface UserPointService extends BaseService<UserPointInfo> {
    UserPointVo queryUserPoint(UserPointParam userPointParam);

    int modifyUserPoint(UserPointParam userPointParam) throws Exception;

    int insertUserPoint(UserPointInfo userPointInfo, UserPointParam userPointParam) throws Exception;
}
