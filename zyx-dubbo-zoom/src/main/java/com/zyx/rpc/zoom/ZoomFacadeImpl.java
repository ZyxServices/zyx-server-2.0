package com.zyx.rpc.zoom;

import com.zyx.constants.Constants;
import com.zyx.constants.coin.CoinConstants;
import com.zyx.constants.zoom.ZoomConstants;
import com.zyx.param.attention.AttentionParam;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.attention.UserAttentionService;
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
}
