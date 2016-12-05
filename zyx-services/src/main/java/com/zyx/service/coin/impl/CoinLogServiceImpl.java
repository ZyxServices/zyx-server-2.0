package com.zyx.service.coin.impl;

import java.util.List;
import com.zyx.entity.coin.CoinLog;
import com.zyx.mapper.coin.CoinLogMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.coin.CoinLogService;
import com.zyx.vo.coin.CoinDayLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Service("coinLogService")
public class CoinLogServiceImpl extends BaseServiceImpl<CoinLog> implements CoinLogService {
    public CoinLogServiceImpl() {
        super(CoinLog.class);
    }

    @Autowired
    CoinLogMapper coinLogMapper;
    @Override
    public List<CoinDayLogVo> countOperLog(Integer userId, long start, long end) {
        return coinLogMapper.countOperLog(userId,start,end);
    }
}
