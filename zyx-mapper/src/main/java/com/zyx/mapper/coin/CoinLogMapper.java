package com.zyx.mapper.coin;

import com.zyx.entity.coin.CoinLog;
import com.zyx.entity.coin.SportCoin;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.coin.CoinDayLogVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Repository("coinLogMapper")
public interface CoinLogMapper extends BaseMapper<CoinLog> {
    public List<CoinDayLogVo> countOperLog(@Param(value = "userId") Integer userId, @Param(value = "startTime")long start,@Param(value = "endTime") long end);
}
