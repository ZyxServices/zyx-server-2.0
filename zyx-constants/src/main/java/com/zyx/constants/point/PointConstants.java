package com.zyx.constants.point;

import com.zyx.constants.Constants;

/**
 * Created by wms on 2016/11/1.
 *
 * @author WeiMinSheng
 * @version V2.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/11/1
 */
public interface PointConstants extends Constants {

    //======================积分表。积分类型=============================
    /**
     * 攀岩
     */
    int POINT_TYPE_PANYAN = 1;

    //======================积分记录表。表名=============================
    /**
     * 攀岩表
     */
    String TABLE_PANYAN = "user_point_panyan_detail";

    //======================获取途径类型=================================
    /**
     * 发布评论
     */
    int DETAIL_TYPE_FBPL = 1;
    int POINT_COUNT_FBPL = 5;
    String DETAIL_TYPE_MSG_FBPL = "发布评论";

    /**
     * 发布动态
     */
    int DETAIL_TYPE_FBDT = 2;
    int POINT_COUNT_FBDT = 10;
    String DETAIL_TYPE_MSG_FBDT = "发布动态";

    /**
     * 发布活动
     */
    int DETAIL_TYPE_FBHD = 3;
    int POINT_COUNT_FBHD = 15;
    String DETAIL_TYPE_MSG_FBHD = "发布活动";

    /**
     * 分享
     */
    int DETAIL_TYPE_FX = 4;
    int POINT_COUNT_FX = 5;
    String DETAIL_TYPE_MSG_FX = "分享";

    /**
     * 点赞
     */
    int DETAIL_TYPE_DZ = 5;
    int POINT_COUNT_DZ = 5;
    String DETAIL_TYPE_MSG_DZ = "点赞";

    /**
     * 报名
     */
    int DETAIL_TYPE_BM = 6;
    int POINT_COUNT_BM = 10;
    String DETAIL_TYPE_MSG_BM = "报名";

    /**
     * 装备秀
     */
    int DETAIL_TYPE_ZBX = 7;
    int POINT_COUNT_ZBX = 10;
    String DETAIL_TYPE_MSG_ZBX = "装备秀";

    /**
     * 举报
     */
    int DETAIL_TYPE_JB = 8;
    int POINT_COUNT_JB = -25;
    String DETAIL_TYPE_MSG_JB = "举报";

}
