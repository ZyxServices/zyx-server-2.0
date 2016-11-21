package com.zyx.rpc.zoom;

import com.zyx.constants.Constants;
import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.param.attention.AttentionParam;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.attention.UserAttentionService;
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


    @Override
    public Map<String, Object> addFollow(Integer fromUserId, Integer toUserId) {
        if (Objects.equals(fromUserId, null) || Objects.equals(toUserId, null)) {
            return ZoomConstants.MAP_500;
        }
        AttentionParam attentionParam = new AttentionParam(fromUserId, toUserId, 1);
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
    public Map<String, Object> myFollowCon(Integer loginUserId, Integer start, Integer pageSize) {
        return concernService.myFollowCon(loginUserId, start, pageSize);
    }

    @Override
    public Map<String, Object> addCern(Integer userId, Integer type, String cernTitle, String content, String cernImgurl, String videoUrl, Integer visible) {
        return concernService.addCern(userId, type, cernTitle, content, cernImgurl, videoUrl, visible);
    }

    @Override
    public Map<String, Object> addZan(Integer body_id, Integer body_type, Integer account_id) {
        return zanService.addZan(body_id, body_type, account_id);
    }

    @Override
    public Map<String, Object> addEquip(String title, String content, Integer accountId, Integer labelId) {
        return equipService.addEquip(title, content, accountId, labelId);
    }

    @Override
    public Map<String, Object> queryEquip(Integer eId) {
        return equipService.queryEquip(eId);
    }
}
