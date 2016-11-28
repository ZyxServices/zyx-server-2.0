package com.zyx.mapper.activity;

import com.zyx.entity.activity.ActivityMember;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.activity.QueryActivityMemberParam;
import com.zyx.vo.activity.ActivityVo;
import com.zyx.vo.activity.MemberActivityVo;
import com.zyx.vo.activity.MemberUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * Created by Rainbow
 *
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/9
 */
@Repository("activityMemberMapper")
public interface ActivityMemberMapper extends BaseMapper<ActivityMember> {

    /**
     * 通过活动Id查询报名列表
     * @param memberParam
     * @return
     */
    List<MemberUserVo> findMemberById(QueryActivityMemberParam memberParam);

    /**
     * 通过用户ID查询当前用户报名的活动
     * @param memberParam
     * @return
     */
    List<MemberActivityVo> findMemberByUserId(QueryActivityMemberParam memberParam);

    /**
     * 验证是否存在数据
     * @param memberParam
     * @return
     */
    List<MemberActivityVo> verificationMember(ActivityMember memberParam);

    /**
     * 取消报名
     * @param memberParam
     * @return
     */
    int delMember(QueryActivityMemberParam memberParam);

}
