package com.zyx.mapper.coin;

import com.zyx.entity.coin.SportCoin;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.coin.SportCoinVo;
import org.springframework.stereotype.Repository;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Repository("sportCoinMapper")
public interface SportCoinMapper extends BaseMapper<SportCoin>{
    /**
     * 按用户ID查询运动币情况
     * @param userId
     * @return
     */
    SportCoinVo selectSportCoin(Integer userId);
}
