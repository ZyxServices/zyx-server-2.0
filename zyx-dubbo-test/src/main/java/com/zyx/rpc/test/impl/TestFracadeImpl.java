package com.zyx.rpc.test.impl;

import com.zyx.rpc.coin.SportCoinFracade;
import com.zyx.rpc.test.TestFracade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MrDeng on 2016/10/31.
 */
@Service("testFracade")
public class TestFracadeImpl implements TestFracade {
    @Autowired
    SportCoinFracade sportCoinFracade;
    @Override
    public void modify(Integer userId,Integer operType, Integer coin) {
        sportCoinFracade.modify(userId,operType,coin);
    }

    @Override
    public Integer search(Integer userId) {
       return sportCoinFracade.search(userId);
    }
}
