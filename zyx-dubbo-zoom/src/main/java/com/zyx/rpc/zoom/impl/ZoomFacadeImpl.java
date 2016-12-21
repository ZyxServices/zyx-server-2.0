package com.zyx.rpc.zoom.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.attention.UserAttentionConstants;
import com.zyx.constants.coin.CoinConstants;
import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.entity.record.SportRecord;
import com.zyx.entity.zoom.Concern;
import com.zyx.param.attention.AttentionParam;
import com.zyx.param.user.UserConcernParam;
import com.zyx.rpc.zoom.ZoomFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.attention.UserAttentionService;
import com.zyx.service.coin.SportCoinService;
import com.zyx.service.record.SportRecordService;
import com.zyx.service.zoom.ConcernService;
import com.zyx.service.zoom.EquipService;
import com.zyx.service.zoom.ZanService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountAttentionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.rpc.zoom
 * Create by XiaoWei on 2016/11/9
 */
@Service("zoomFacade")
public class ZoomFacadeImpl implements ZoomFacade {

    @Resource
    private UserAttentionService attentionService;

    @Resource
    private AccountInfoService accountInfoService;

    @Resource
    private ConcernService concernService;

    @Resource
    private ZanService zanService;

    @Resource
    private EquipService equipService;

    @Resource
    private UserAttentionService userAttentionService;

    @Resource
    SportCoinService sportCoinService;

    @Resource
    SportRecordService sportRecordService;

    @Override
    public Map<String, Object> addFollow(Integer fromUserId, Integer toUserId) {
        if (Objects.equals(fromUserId, null) || Objects.equals(toUserId, null)) {
            return ZoomConstants.MAP_500;
        }
        AttentionParam attentionParam = new AttentionParam(fromUserId, toUserId, 1);
        if (userAttentionService.selectAttentionCount(attentionParam) > 0) {
            return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70003, UserAttentionConstants.ATTENTION_70003_MSG);
        }
        Integer result = attentionService.addAttention(attentionParam);
        if (result > 0) {
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, result);
        }
        return ZoomConstants.MAP_500;
    }

    @Override
    public Map<String, Object> getNoAttentionUser(Integer loginUserId) {
        List<AccountAttentionVo> accountAttentionVos = accountInfoService.getNoAttentionUser(loginUserId);
        return MapUtils.buildSuccessMap(ZoomConstants.SUCCESS, ZoomConstants.SUCCESS_MSG, accountAttentionVos);
    }

    @Override
    public Map<String, Object> getOneConcern(Integer concernId, Integer accountId) {
        return concernService.getOne(concernId, accountId);
    }

    @Override
    public Map<String, Object> myFollowCon(Integer loginUserId, Integer page, Integer pageSize) {
        return concernService.myFollowCon(loginUserId, page, pageSize);
    }

    @Override
    public Map<String, Object> addCern(Integer userId, Integer type, String content, String cernImgurl, String videoUrl, Integer visible, String local) {
        Map map = concernService.addCern(userId, type, content, cernImgurl, videoUrl, visible, local);
        if (null != map && !map.isEmpty() && map.get(ZoomConstants.STATE).equals(ZoomConstants.SUCCESS))
            sportCoinService.modifyCoin(userId, CoinConstants.OperType.PUBLISH_COMMENT);
        return map;
    }

    @Override
    public Map<String, Object> showSportRecord(Integer userId, Integer type, String content, String cernImgurl, String videoUrl, Integer visible, String local,Integer recordId) {
        Map map = concernService.addCern(userId, type, content, cernImgurl, videoUrl, visible, local);
        if (null != map && !map.isEmpty() && map.get(ZoomConstants.STATE).equals(ZoomConstants.SUCCESS))
            sportCoinService.modifyCoin(userId, CoinConstants.OperType.PUBLISH_COMMENT);
        if(recordId!=null&&type!=null&&type==ZoomConstants.CONCERN_TYPE.SHOW_RECORD){
            Concern conc = (Concern) map.get(Constants.DATA);
            if(null!=conc&&conc.getId()!=null){
                SportRecord entity = new SportRecord();
                entity.setId(recordId);
                entity.setConcernId(conc.getId());
                sportRecordService.updateNotNull(entity);
            }
        }
        return map;
    }
    @Override
    public Map<String, Object> addZan(Integer body_id, Integer body_type, Integer account_id) {
        Map map = zanService.addZan(body_id, body_type, account_id);
        //点赞 获取运动币
        if (null != map && !map.isEmpty() && map.get(ZoomConstants.STATE).equals(ZoomConstants.SUCCESS))
            sportCoinService.modifyCoin(account_id, CoinConstants.OperType.LIKED);
        return map;
    }

    @Override
    public Map<String, Object> addEquip(String title, String content, Integer accountId, Integer labelId, String imgUrls) {
        Map map = equipService.addEquip(title, content, accountId, labelId, imgUrls);
        if (null != map && !map.isEmpty() && map.get(ZoomConstants.STATE).equals(ZoomConstants.SUCCESS))
            sportCoinService.modifyCoin(accountId, CoinConstants.OperType.PUBLISH_COMMENT);
        return map;
    }

    @Override
    public Map<String, Object> queryEquip(Integer eId) {
        return equipService.queryEquip(eId);
    }

    @Override
    public Map<String, Object> queryOne(Integer eId) {
        return equipService.queryOne(eId);
    }

    @Override
    public Map<String, Object> unFollow(Integer fromUserId, Integer toUserId) {
        try {
//            // 判断token是否失效
//            if (isTokenFailure(attentionParam.getToken())) {
//                return UserAttentionConstants.MAP_TOKEN_FAILURE;
//            }
            AttentionParam attentionParam = new AttentionParam(fromUserId, toUserId);
            attentionParam.setType(1);// 关注、粉丝
            int result = userAttentionService.deleteAttention(attentionParam);
            if (result == 1) {// 成功
                return MapUtils.buildSuccessMap(UserAttentionConstants.SUCCESS, UserAttentionConstants.SUCCESS_MSG, result);
            } else {
                return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70004, UserAttentionConstants.ATTENTION_70004_MSG);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return UserAttentionConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> getRecommend(UserConcernParam userConcernParam) {
        return concernService.getRecommend(userConcernParam);
    }

    @Override
    public Map<String, Object> queryEquipByLabelId(Integer labelId, Integer loginUserId, Integer start, Integer pageSize) {
        return equipService.queryByLabelId(labelId, loginUserId, start, pageSize);
    }

    @Override
    public Map<String, Object> getConcernZanUser(Integer concernId, Integer max) {
        return concernService.getConcernZanUser(concernId, max);
    }

    @Override
    public Map<String, Object> delCern(Integer id, Integer loginUserId) {
        return concernService.delCern(id, loginUserId);
    }
}
