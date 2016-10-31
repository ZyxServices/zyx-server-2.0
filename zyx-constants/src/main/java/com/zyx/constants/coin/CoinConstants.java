package com.zyx.constants.coin;

/**
 * Created by MrDeng on 2016/10/31.
 * 运动币模块 静态变量
 */
public interface CoinConstants {

    enum OperType {
        /**
         * 新用户第一次使用
         */
        NEW_USER(1);
        private Integer operType;

        OperType(Integer operType) {
            this.operType = operType;
        }

        Integer getOperType() {
            return operType;
        }
    }
}
