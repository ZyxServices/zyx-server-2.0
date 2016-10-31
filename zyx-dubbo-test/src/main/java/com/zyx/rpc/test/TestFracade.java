package com.zyx.rpc.test;

/**
 * Created by MrDeng on 2016/10/31.
 */
public interface TestFracade {

    /**
     * 增加用户运动币
     * @param userId
     * @param coin
     */
    public void modify(Integer userId,Integer operType,Integer coin);

    /**
     * 查询用户运动币
     * @param userId
     * @return
     */
    public Integer search(Integer userId);
}
