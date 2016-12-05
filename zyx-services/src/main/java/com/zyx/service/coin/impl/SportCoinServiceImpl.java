package com.zyx.service.coin.impl;

import com.zyx.constants.coin.CoinConstants;
import com.zyx.entity.coin.CoinLog;
import com.zyx.entity.coin.SportCoin;
import com.zyx.mapper.coin.CoinLogMapper;
import com.zyx.mapper.coin.SportCoinMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.coin.CoinLogService;
import com.zyx.service.coin.SportCoinService;
import com.zyx.vo.coin.SportCoinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Service("sportCoinService")
public class SportCoinServiceImpl extends BaseServiceImpl<SportCoin> implements SportCoinService {
    public SportCoinServiceImpl() {
        super(SportCoin.class);
    }

    @Autowired
    SportCoinMapper sportCoinMapper;
    @Autowired
    CoinLogMapper coinLogMapper;

    @Override
    public void modifyCoin(Integer userId,  CoinConstants.OperType operType) {
        modifyCoin(userId,operType.getOperType(),null);
    }

    @Override
    public void modifyCoin(Integer userId, Integer operType, Long coin) {
        CoinLog clog = new CoinLog();
        clog.setUserId(userId);
        clog.setOperId(operType);
        int count = coinLogMapper.selectCount(clog);
        if(CoinConstants.COIN_TOTAL_OPER_UPPER_TIMES.get(operType)==null||CoinConstants.COIN_TOTAL_OPER_UPPER_TIMES.get(operType) <= count) {
            return;
        }
        //TODO 验证当天是否达到操作上限次数
//        COIN_DAY_OPER_UPPER_TIMES
        if(coin==null)
            coin = CoinConstants.COIN_OPER_NUMBER.get(operType);
        //实际操作
        SportCoin record = new SportCoin();
        record.setUserId(userId);
        List<SportCoin> records = select(record);
        int n = -1;
        if (records == null || records.size() == 0) {
            record.setUserId(userId);
            record.setState(1);
            record.setCoin(coin);
            record.setCreateTime(System.currentTimeMillis());
            record.setModifyTime(record.getCreateTime());
            n = save(record);
        } else {
            record = records.get(0);
            record.setUserId(userId);
            record.setCoin(record.getCoin() == null ? coin : (record.getCoin() + coin));
            record.setModifyTime(System.currentTimeMillis());
            n = updateNotNull(record);
        }

        //记录日志
        CoinLog log = new CoinLog();
        log.setCreateTime(System.currentTimeMillis());
        log.setUserId(userId);
        log.setCoinNum(coin);
        log.setState(n > 0 ? 1 : -1);
        log.setOperId(operType);
        coinLogMapper.insert(log);
    }

    @Override
    public List<SportCoinVo> getSportCoins() {
        return null;
    }

    @Override
    public SportCoinVo getSportCoin(Integer userId) {
        return sportCoinMapper.selectSportCoin(userId);
    }
}
