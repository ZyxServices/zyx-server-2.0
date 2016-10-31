package com.zyx.rpc.coin;

/**
 * Created by MrDeng on 2016/10/31.
 */
public interface SportCoinFracade {

    public void modify(Integer userId, Integer operType);
    /**
     *
     * 增加用户运动币
     * @param userId 必传
     * @param operType 必传
     * @param coin 非必传
     */
    public void modify(Integer userId, Integer operType, Integer coin);

    /**
     * 查询用户运动币
     * @param userId
     * @return
     */
    public Integer search(Integer userId);
}
