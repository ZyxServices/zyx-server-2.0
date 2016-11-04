package com.zyx.constants.coin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MrDeng on 2016/10/31.
 * 运动币模块 静态变量
 */
public interface CoinConstants {

    enum OperType {
        /**
         * 未指定类型
         */
        OTHER(0),
        /**
         * 新用户第一次使用
         */
        NEW_USER(1),
        /**
         * 完善资料
         */
        REFINED_INFO(2),
        /**
         * 分享
         */
        SHARE(3),
        /**
         * 关注 点赞
         */
        LIKED(4),
        /**
         * 发布评论
         */
        PUBLISH_COMMENT(5),
        /**
         * 发布活动
         */
        PUBLISH_ACTIVITY(6),
        /**
         * 发布动态
         */
        PUBLISH_DYNAMIC(7),
        /**
         * 被举报
         */
        ACCUSATION(8),
        /**
         * 充值
         */
        RECHARGE(9);
        private Integer operType;

        OperType(Integer operType) {
            this.operType = operType;
        }

        public Integer getOperType() {
            return operType;
        }
    }

    /**
     * 运动币操作上限次数
     */
    Map<Integer, Integer> COIN_OPER_UPPER_TIMES = new HashMap<Integer, Integer>() {
        {
            put(0, Integer.MAX_VALUE);
            put(1, 1);
            put(2, 1);
            put(3, 5);
            put(4, 5);
            put(5, 5);
            put(6, Integer.MAX_VALUE);
            put(7, 10);
            put(8, Integer.MAX_VALUE);
            put(9, Integer.MAX_VALUE);
        }
    };
    /**
     * 运动币每次获得个数
     */
    Map<Integer, Long> COIN_OPER_NUMBER = new HashMap<Integer, Long>() {
        {
            put(0, Long.MAX_VALUE);
            put(1, 5L);
            put(2, 2L);
            put(3, 1L);
            put(4, 1L);
            put(5, 1L);
            put(6, 5L);
            put(7, 2L);
            put(8, -2L);
            put(9, Long.MAX_VALUE);
        }
    };
}
