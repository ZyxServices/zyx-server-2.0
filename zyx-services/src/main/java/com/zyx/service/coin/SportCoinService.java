package com.zyx.service.coin;

import com.zyx.constants.coin.CoinConstants;
import com.zyx.entity.BaseEntity;
import com.zyx.entity.coin.SportCoin;
import com.zyx.param.coin.SportCoinParam;
import com.zyx.service.BaseService;
import com.zyx.vo.coin.SportCoinVo;

import java.util.List;

/**
 * Created by MrDeng on 2016/10/31.
 */
public interface SportCoinService extends BaseService<SportCoin> {
    public void modifyCoin(Integer userId,CoinConstants.OperType operType);
    public void modifyCoin(Integer userId,Integer operType,Long coin);
    public List<SportCoinVo> getSportCoins();
    public SportCoinVo getSportCoin(Integer userId);
}
