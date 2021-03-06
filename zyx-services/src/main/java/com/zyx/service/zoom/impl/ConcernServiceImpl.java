package com.zyx.service.zoom.impl;


import com.zyx.constants.Constants;
import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.entity.attention.UserAttention;
import com.zyx.entity.record.SportRecord;
import com.zyx.entity.zoom.Concern;
import com.zyx.mapper.zoom.ConcernMapper;
import com.zyx.mapper.system.ZanMapper;
import com.zyx.param.attention.AttentionParam;
import com.zyx.param.user.UserConcernParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.zoom.ConcernService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountAttentionVo;
import com.zyx.vo.account.UserIconVo;
import com.zyx.vo.attention.AttentionVo;
import com.zyx.vo.zoom.MyFollowVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static com.zyx.constants.Constants.*;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service
public class ConcernServiceImpl extends BaseServiceImpl<Concern> implements ConcernService {

    @Resource
    private ConcernMapper concernMapper;

//    @Resource
//    private CollectionMapper collectionMapper;
//
//    @Resource
//    private PageViwesService pageViwesService;

    @Resource
    private ZanMapper zanMapper;

    @Resource
    private AccountInfoService accountInfoService;

    public ConcernServiceImpl() {
        super(Concern.class);
    }


    @Override
    public Map<String, Object> addCern(Integer userId, Integer type, String content, String cernImgurl, String videoUrl, Integer visible, String local) {
        Concern insertCern = new Concern();
        insertCern.setCreateTime(new Date().getTime());
        Optional.ofNullable(userId).ifPresent(insertCern::setUserId);
        Optional.ofNullable(type).ifPresent(insertCern::setType);
//        Optional.ofNullable(cernTitle).ifPresent(insertCern::setTopicTitle);
        Optional.ofNullable(content).ifPresent(insertCern::setTopicContent);
        Optional.ofNullable(cernImgurl).ifPresent(insertCern::setImgUrl);
        Optional.ofNullable(videoUrl).ifPresent(insertCern::setVideoUrl);
        Optional.ofNullable(visible).ifPresent(insertCern::setTopicVisible);
        Optional.ofNullable(local).ifPresent(insertCern::setLocal);
        insertCern.setAppType(1);
        insertCern.setState(0);
        save(insertCern);
        return MapUtils.buildSuccessMap(Constants.SUCCESS, ZoomConstants.PG_ERROR_CODE_33000_MSG, insertCern);
    }

    @Override
    public Map<String, Object> delCern(Integer id, Integer loginUserId) {
        if (id == null) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30021, ZoomConstants.PG_ERROR_CODE_30021_MSG);
        }
        Concern concernFind = concernMapper.getOne(id, loginUserId);
        if (concernFind != null) {
            if (Objects.equals(concernFind.getUserId(), loginUserId)) {
                Integer result = concernMapper.delConcern(id);
                if (result > 0) {
                    return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_39000_MSG, null);
                }
            } else {
                return MapUtils.buildSuccessMap(ZoomConstants.PG_ERROR_CODE_30029, ZoomConstants.PG_ERROR_CODE_30029_MSG, null);
            }
        } else {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30031, ZoomConstants.PG_ERROR_CODE_30031_MSG);
        }

        return ZoomConstants.MAP_500;
    }


    @Override
    public Map<String, Object> starRandom(Integer type, Integer n) {
        Map<String, Object> map = new HashMap<>();
        try {
            Optional.ofNullable(n).orElse(10);
            List<Concern> randomList = concernMapper.starRandom(type, n);
//            map.put(Constants.STATE, Constants.MSG_SUCCESS);
//            map.put(ZoomConstants.PG_RESULT, Optional.ofNullable(randomList).orElse(null));
//            return map;
            return MapUtils.buildSuccessMap(Constants.SUCCESS, ZoomConstants.PG_ERROR_CODE_34000_MSG, Optional.ofNullable(randomList).orElse(null));
        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myFollowCon(Integer loginUserId, Integer start, Integer pageSize) {
        try {
            start = Optional.ofNullable(start).orElse(0);
            pageSize = Optional.ofNullable(pageSize).orElse(0);
            if (Objects.equals(loginUserId, null)) {
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30000, ZoomConstants.PG_ERROR_CODE_30000_MSG);
            }
            AttentionParam attentionParam = new AttentionParam();
            attentionParam.setFromId(loginUserId);
            List<UserAttention> attentionIds = concernMapper.getAttentionIds(loginUserId);
            List<Integer> ids = new ArrayList<>();
            if (attentionIds.size() > 0) {
                ids.addAll(attentionIds.stream().map(UserAttention::getToUserId).collect(Collectors.toList()));
            }
            if (!Objects.equals(loginUserId, null)) {
                ids.add(loginUserId);
            }
            List<MyFollowVo> myFollowVos = concernMapper.myFollowList(ids, (start - 1) * pageSize, pageSize);
//            setPageViews(myFollowVos);
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_34000_MSG, myFollowVos);
        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }

    }

    @Override
    public List<MyFollowVo> queryMyConcernList(UserConcernParam userConcernParam) {
        if (userConcernParam == null) {
            return null;
        }
        List<MyFollowVo> list = concernMapper.myConcernList(userConcernParam);
//        setPageViews(list);
        return list;
    }

    @Override
    public Map<String, Object> starConcern(Integer start, Integer pageSize) {
        try {
            start = Optional.ofNullable(start).orElse(0);
            pageSize = Optional.ofNullable(pageSize).orElse(0);
            List<MyFollowVo> myFollowVos = concernMapper.starConcern(start * pageSize, pageSize);
//            setPageViews(myFollowVos);
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_34000_MSG, myFollowVos);
        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }
    }

//    private void setPageViews(List<MyFollowVo> myFollowVos) {
//        myFollowVos.stream().filter(e -> e.getId() != null).forEach(s -> {
//            if (!Objects.equals(s.getFromType(), null)) {
//                switch (s.getFromType()) {
//                    case 1:
//                        s.setPageViews(pageViwesService.getPageViwesByInternal(0, s.getFromId()));
//                        break;
//                    case 2:
//                        s.setPageViews(pageViwesService.getPageViwesByInternal(2, s.getFromId()));
//                        break;
//                    case 3:
//                        s.setPageViews(pageViwesService.getPageViwesByInternal(3, s.getFromId()));
//                        break;
//                }
//            } else {
//                s.setPageViews(pageViwesService.getPageViwesByInternal(1, s.getId()));
//            }
//        });
//    }

    @Override
    public Integer fromConcern(Integer fromId, Integer fromType, Object fromObj) {
        if (Objects.equals(fromId, null)) {
            return 0;
        }
        if (Objects.equals(fromType, null)) {
            return 0;
        }
        if (Objects.equals(fromObj, null)) {
            return 0;
        }
        switch (fromType) {
            case MODULE_ACTIVITY://活动（求约）
                //活动
                Activity activity = (Activity) fromObj;
                Concern concernActivity = new Concern();
                concernActivity.setFromId(fromId);
                concernActivity.setFromType(fromType);
                concernActivity.setCreateTime(new Date().getTime());
                if (!Objects.equals(activity.getImgUrls(), null)) {
                    concernActivity.setImgUrl(activity.getImgUrls());
                }
                concernActivity.setTopicTitle(activity.getTitle());
                concernActivity.setTopicContent(activity.getDescContent());
                concernActivity.setTopicVisible(1);
                concernActivity.setUserId(activity.getUserId());
                concernActivity.setState(0);
                return concernMapper.insert(concernActivity);
            case MODULE_EQUIP://装备控
                return null;
            case MODULE_SPORT_RECORD://（记录）
                SportRecord sportRecord = (SportRecord) fromObj;
                Concern concernSport = new Concern();
                concernSport.setFromId(fromId);
                concernSport.setFromType(fromType);
                concernSport.setCreateTime(sportRecord.getCreateTime());
                concernSport.setTopicTitle("攀岩记录");
                concernSport.setTopicContent(sportRecord.getSpendTime().toString());
                concernSport.setTopicVisible(1);
                concernSport.setUserId(sportRecord.getUserId());
                concernSport.setState(0);
                return concernMapper.insert(concernSport);
            case MODULE_ARTICLE://文章/教程（记录）
                return null;
        }
        return 0;
    }

    @Override
    public Map<String, Object> getOne(Integer concernId, Integer accountId) {
        try {
            if (Objects.equals(concernId, null)) {
                return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30021, ZoomConstants.PG_ERROR_CODE_30021_MSG);
            }
            MyFollowVo myFollowVo = concernMapper.getOne(concernId, accountId);
//            if (!Objects.equals(myFollowVo, null)) {
//                myFollowVo.setTopicContent("<p>" + myFollowVo.getTopicContent() + "</p>");
//                if (myFollowVo.getImgUrl() != null) {
//                    if (myFollowVo.getImgUrl().contains(",")) {
//                        StringBuilder sb = new StringBuilder();
//                        String[] imgOne = myFollowVo.getImgUrl().split(",");
//                        for (int i = 0; i < imgOne.length; i++) {
//                            sb.append("<img src='http://image.tiyujia.com/" + imgOne[i] + "'></img>");
//                        }
//                        myFollowVo.setTopicContent(myFollowVo.getTopicContent() + "</br>" + sb.toString());
//                    }
//                }
//            }
            Map resultMap = new HashMap<>();
//            CollectionParam param = new CollectionParam();
//            Boolean isCollection = false;
            Boolean isZan = false;
//            if (!Objects.equals(accountId, null)) {
//                param.setUserId(accountId);
//                param.setModel(Constants.MODEL_CONCERN);
//                param.setModelId(concernId);
//                CollectionVo collectionFind = collectionMapper.existCollection(param);
//                if (!Objects.equals(collectionFind, null)) {
//                    isCollection = true;
//                }
            isZan = zanMapper.exist(concernId, 2, accountId) > 0 ? true : false;
//            }
            resultMap.put("concern", myFollowVo);
//            resultMap.put("isCollection", isCollection);
            resultMap.put("isZan", isZan);
            return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_34000_MSG, resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            return ZoomConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> getRecommend(UserConcernParam userConcernParam) {
        List<AccountAttentionVo> accountAttentionVos = accountInfoService.getNoAttentionUser(userConcernParam.getUserId());
        List<Integer> ids = new ArrayList<>();
        if (accountAttentionVos.size() > 0) {
            ids.addAll(accountAttentionVos.stream().map(AccountAttentionVo::getId).collect(Collectors.toList()));
        }
        List<MyFollowVo> myFollowVos = new ArrayList<>();
        if (ids.size() > 0) {
            int start = (userConcernParam.getPage() - 1) * userConcernParam.getPageSize();
            int pageSize = userConcernParam.getPageSize();
            myFollowVos = concernMapper.getRecommend(userConcernParam.getUserId(), ids, start, pageSize);
        }
        return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.PG_ERROR_CODE_34000_MSG, myFollowVos);
    }

    @Override
    public Map<String, Object> getConcernZanUser(Integer concernId, Integer max) {
        if (Objects.equals(concernId, null)) {
            return MapUtils.buildErrorMap(ZoomConstants.PG_ERROR_CODE_30021, ZoomConstants.PG_ERROR_CODE_30021_MSG);
        }
        try {
            max = Optional.ofNullable(max).orElse(5);
            List<UserIconVo> userIconVos = concernMapper.getConcernZanUser(concernId, max);
            Integer counts = concernMapper.getConcernZanUserCount(concernId);
            Map<String, Object> map = new HashMap<>();
            map.put("totalCount", counts);
            map.put("userList", userIconVos);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, map);
        } catch (Exception e) {
            e.printStackTrace();
            return MAP_500;
        }
    }

}
