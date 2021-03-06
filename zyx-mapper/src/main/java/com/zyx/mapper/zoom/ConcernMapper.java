package com.zyx.mapper.zoom;

import com.zyx.entity.attention.UserAttention;
import com.zyx.entity.zoom.Concern;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.user.UserConcernParam;
import com.zyx.vo.account.UserIconVo;
import com.zyx.vo.zoom.MyFollowVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xw on 16-6-12.
 */
@Repository("concernMapper")
public interface ConcernMapper extends BaseMapper<Concern> {
    List<Concern> starRandom(@Param("type") Integer type, @Param("n") Integer n);

    List<UserAttention> getAttentionIds(@Param("loginUserId") Integer logInUserId);

    List<MyFollowVo> myFollowList(@Param("ids") List<Integer> ids, @Param("start") Integer start, @Param("end") Integer end);

    /**
     * 我的动态列表
     */
    List<MyFollowVo> myConcernList(UserConcernParam userConcernParam);

    List<MyFollowVo> starConcern(@Param("start") Integer max, @Param("end") Integer end);

    MyFollowVo getOne(@Param("id") Integer concernId, @Param("loginUserId") Integer loginUserId);

    Integer delConcern(@Param("id") Integer id);

    List<MyFollowVo> getRecommend(@Param("loginUserId") Integer loginUserId, @Param("ids") List<Integer> ids, @Param("start") Integer start, @Param("end") Integer end);

    List<UserIconVo> getConcernZanUser(@Param("concernId") Integer concernId, @Param("max") Integer max);

    Integer getConcernZanUserCount(@Param("concernId") Integer concernId);


}
