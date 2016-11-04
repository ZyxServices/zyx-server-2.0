package com.zyx.service.coin.impl;

import com.zyx.constants.coin.CoinConstants;
import com.zyx.entity.coin.CoinLog;
import com.zyx.entity.coin.SportCoin;
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
    CoinLogService coinLogService;

    @Override
    public void modifyCoin(Integer userId, Integer operType, Long coin) {


        CoinLog clog = new CoinLog();
        clog.setUserId(userId);
        clog.setOperId(operType);
        int count = coinLogService.selectCount(clog);
        if(CoinConstants.COIN_OPER_UPPER_TIMES.get(operType)==null||CoinConstants.COIN_OPER_UPPER_TIMES.get(operType) <= count) {
            return;
        }
        if(coin==null)
            coin = CoinConstants.COIN_OPER_NUMBER.get(operType);
        //实际操作
        SportCoin record = new SportCoin();
        record.setUserId(userId);
        List<SportCoin> records = select(record);
        int n = -1;
        if (records == null || records.size() == 0) {
//            System.out.println("新增运动币");
            record.setUserId(userId);
            record.setState(1);
            record.setCoin(coin);
            record.setCreateTime(System.currentTimeMillis());
//            System.out.println(JSON.toJSONString(record));
            n = save(record);
        } else {
            record = records.get(0);
//            System.out.println("修改运动币");
            record.setUserId(userId);
            record.setCoin(record.getCoin() == null ? coin : (record.getCoin() + coin));
//            System.out.println(JSON.toJSONString(record));
            n = updateNotNull(record);
        }

        //记录日志
//        System.out.println("日志记录"+n);
        CoinLog log = new CoinLog();
        log.setCreateTime(System.currentTimeMillis());
        log.setUserId(userId);
        log.setCoinNum(coin);
        log.setState(n > 0 ? 1 : -1);
        log.setOperId(operType);
//        System.out.println(JSON.toJSONString(record));
        coinLogService.save(log);
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
