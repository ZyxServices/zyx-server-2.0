package com.zyx.rpc.test.impl;

import com.zyx.rpc.coin.SportCoinFacade;
import com.zyx.rpc.test.TestFracade;
import com.zyx.vo.coin.SportCoinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Service("testFracade")
public class TestFracadeImpl implements TestFracade {
    @Autowired
    SportCoinFacade sportCoinFacade;
    @Override
    public void modify(Integer userId,Integer operType, Long coin) {
        sportCoinFacade.modify(userId,operType,coin);
    }

    @Override
    public SportCoinVo search(Integer userId) {
       return sportCoinFacade.search(userId);
    }
}
