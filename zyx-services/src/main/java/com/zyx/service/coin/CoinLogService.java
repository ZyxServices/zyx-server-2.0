package com.zyx.service.coin;

import java.util.List;
import com.zyx.entity.coin.CoinLog;
import com.zyx.service.BaseService;
import com.zyx.vo.coin.CoinDayLogVo;

/**
 * Created by MrDeng on 2016/10/31.
 */
public interface CoinLogService extends BaseService<CoinLog> {
    /**
     * 用户一段时间内 操作统计
     * @param userId
     * @param start
     * @param end
     * @return
     */
    public List<CoinDayLogVo> countOperLog(Integer userId, long start, long end);
}
