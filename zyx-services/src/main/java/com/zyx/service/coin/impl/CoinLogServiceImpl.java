package com.zyx.service.coin.impl;

import com.zyx.entity.coin.CoinLog;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.coin.CoinLogService;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Service("coinLogService")
public class CoinLogServiceImpl extends BaseServiceImpl<CoinLog> implements CoinLogService {
    public CoinLogServiceImpl() {
        super(CoinLog.class);
    }
}
