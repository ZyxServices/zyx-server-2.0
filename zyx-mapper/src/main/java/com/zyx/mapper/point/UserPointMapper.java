package com.zyx.mapper.point;

import com.zyx.entity.point.UserPointInfo;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.point.UserPointDetailParam;
import com.zyx.param.point.UserPointParam;
import com.zyx.vo.point.UserPointVo;
import org.springframework.stereotype.Repository;

/**
 * Created by wms on 2016/10/31.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/10/31
 */
@Repository("userPointMapper")
public interface UserPointMapper extends BaseMapper<UserPointInfo> {

    UserPointVo queryUserPoint(UserPointParam userPointParam);

    int insertPointDetail(UserPointDetailParam userPointDetailParam);

    int modifyUserPoint(UserPointParam userPointParam);
}
