package com.zyx.service.zoom;

import com.zyx.entity.zoom.Concern;
import com.zyx.param.user.UserConcernParam;
import com.zyx.service.BaseService;
import com.zyx.vo.zoom.MyFollowVo;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoWei on 2016/6/7.
 */
public interface ConcernService extends BaseService<Concern> {
    Map<String, Object> addCern(Integer userId, Integer type, String content, String cernImgurl, String videoUrl, Integer visible,String local);

    Map<String, Object> delCern(Integer id, Integer loginUserId);

    Map<String, Object> starRandom(Integer type, Integer n);

    Map<String, Object> myFollowCon(Integer loginUserId, Integer start, Integer end);

    List<MyFollowVo> queryMyConcernList(UserConcernParam userConcernParam);

    Map<String, Object> starConcern(Integer start, Integer pageSize);

    /**
     * 自动生成动态
     *
     * @param fromId
     * @param fromType {@link com.zyx.constants.Constants}
     * @param formObj
     * @return
     */
    Integer fromConcern(Integer fromId, Integer fromType, Object formObj);

    Map<String, Object> getOne(Integer concernId, Integer accountId);

    Map<String,Object> getRecommend(UserConcernParam userConcernParam);

    Map<String,Object> getConcernZanUser(Integer concernId,Integer max);

}
