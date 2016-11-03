package com.zyx.mapper.coin;

import com.zyx.entity.coin.CoinLog;
import com.zyx.entity.coin.SportCoin;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Repository("coinLogMapper")
public interface CoinLogMapper extends BaseMapper<CoinLog> {
}
