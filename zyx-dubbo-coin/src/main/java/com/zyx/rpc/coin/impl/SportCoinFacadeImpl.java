package com.zyx.rpc.coin.impl;
import java.util.List;
import java.util.Map;

import com.zyx.entity.coin.CoinLog;
import com.zyx.rpc.coin.SportCoinFacade;
import com.zyx.service.coin.CoinLogService;
import com.zyx.service.coin.SportCoinService;
import com.zyx.utils.TimeAreaUtil;
import com.zyx.vo.coin.CoinDayLogVo;
import com.zyx.vo.coin.SportCoinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Service("sportCoinFacade")
public class SportCoinFacadeImpl implements SportCoinFacade {

    @Autowired
    SportCoinService sportCoinService;

    @Autowired
    CoinLogService coinLogService;
    @Override
    public void modify(Integer userId, Integer operType) {
        modify(userId,operType,null);
    }

    @Override
    public void modify(Integer userId,Integer operType,Long coin) {
        sportCoinService.modifyCoin(userId, operType, coin);
    }

    @Override
    public SportCoinVo search(Integer userId) {
        return sportCoinService.getSportCoin(userId);
    }

    @Override
    public List<CoinLog> getCoinLog(Integer userId, Integer operId) {
        CoinLog coinLog = new CoinLog();
        coinLog.setUserId(userId);
        coinLog.setOperId(operId);
        return coinLogService.select(coinLog);
    }

    @Override
    public List<CoinDayLogVo> getDayCoinLog(Integer userId, Integer day) {
        Map<String, Long> timeArea = TimeAreaUtil.getDayTimeArea(day);
        return coinLogService.countOperLog(userId,timeArea.get(TimeAreaUtil.TIME_AREA_START),timeArea.get(TimeAreaUtil.TIME_AREA_END));
    }
}
