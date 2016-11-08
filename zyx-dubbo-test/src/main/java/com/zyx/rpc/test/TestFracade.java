package com.zyx.rpc.test;

import com.zyx.vo.coin.SportCoinVo;

/**
 * Created by MrDeng on 2016/10/31.
 */
public interface TestFracade {

    /**
     * 增加用户运动币
     * @param userId
     * @param coin
     */
    public void modify(Integer userId,Integer operType,Long coin);

    /**
     * 查询用户运动币
     * @param userId
     * @return
     */
    public SportCoinVo search(Integer userId);
}
