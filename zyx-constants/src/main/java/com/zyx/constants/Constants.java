package com.zyx.constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rainbow on 16-6-12.
 *
 * @author SubDong
 * @version V1.0 Copyright (c)2016 tyj-版权所有
 * @title com.zyx.constants
 */
public interface Constants {

    ////////////// 系统标识符 开始//////////////////
    /**
     * 状态 标志
     */
    String STATE = "state";
    /**
     * 状态 标志
     */
    String DATA = "data";
    /**
     * 错误消息 标志
     */
    String ERROR_MSG = "errmsg";

    /**
     * 成功消息 标志
     */
    String SUCCESS_MSG = "successmsg";

    ////////////// 系统标识符 结束//////////////////

    ////////////// 系统状态码 开始//////////////////
    ////////
    /**
     * 请求失败
     */
    int ERROR = 100;
    /**
     * 请求成功
     */
    int SUCCESS = 200;
    /// 参数相关代码 300~399
    /**
     * 参数错误代码
     */
    int PARAM_ERROR = 300;
    /**
     * 参数缺失
     */
    int PARAM_MISS = 301;

    /**
     * 非法参数 如大小 长度 类型不正确
     */
    int PARAM_ILIGAL = 302;

    /**
     * 分页信息错误
     */
    int PARAM_PAGER_ILEGAL = 303;

    /// 请求类型代码
    /**
     * 请求错误
     */
    int REQUEST_ERROR = 400;
    /**
     * 无权限请求
     */
    int REQUEST_UNAUTHORIZED = 401;

    /**
     * TOKEN失效
     */
    int TOKEN_FAILURE = 800;

    /**
     * 无数据
     */
    int NO_DATA = 804;

    //文件类型 900+

    /**
     * 图片上传文件大于5MB
     */
    int AUTH_ERROR_901 = 901;
    /**
     * 服务器错误
     */
    int ERROR_500 = 500;
    /**
     * 文件上传失败
     */
    int AUTH_ERROR_902 = 902;
    /**
     * 文件格式错误
     */
    int AUTH_ERROR_903 = 903;
    ////////
    ////////////// 系统状态码 结束//////////////////

    ////////////// 系统消息 开始//////////////////

    /**
     * 提交频繁
     */
    int SUBMIT_OFTEN = 910;
    String SUBMIT_OFTEN_MSG = "提交频繁";
    /**
     * 错误
     */
    String MSG_ERROR = "error";
    /**
     * 成功
     */
    String MSG_SUCCESS = "success";

    String MSG_PARAM_ERROR = "input paragrams is error";

    String MSG_PARAM_MISS = "missing paragrams";

    String MSG_PARAM_ILIGAL = "ilegal paragram";

    String MSG_PARAM_PAGER_ILEGAL = "iligal pager paragram";

    String MSG_REQUEST_ERROR = "request error";

    String MSG_REQUEST_UNAUTHORIZED = "unauthorized request";

    ////////////// 系统消息 结束//////////////////

    /**
     * 系统错误
     */
    Map<String, Object> MAP_500 = new ConcurrentHashMap() {{
        put(Constants.STATE, Constants.ERROR_500);
        put(Constants.ERROR_MSG, Constants.MSG_ERROR);
    }};

    /**
     * TOKEN失效，401无权限请求
     */
    Map<String, Object> MAP_TOKEN_FAILURE = new ConcurrentHashMap() {{
        put(Constants.STATE, Constants.REQUEST_UNAUTHORIZED);
        put(Constants.ERROR_MSG, Constants.MSG_REQUEST_UNAUTHORIZED);
    }};

    /**
     * 参数缺失
     */
    Map<String, Object> MAP_PARAM_MISS = new ConcurrentHashMap() {{
        put(Constants.STATE, Constants.PARAM_MISS);
        put(Constants.ERROR_MSG, Constants.MSG_PARAM_MISS);
    }};


    /////////////////静态标识符///////////////////

    /**
     * 文章/教程模块标识
     */
    public static final int MODULE_ARTICLE = 0;

    /**
     * 动态模块标识
     */
    public static final int MODULE_CONCERN = 1;

    /**
     * 装备控模块标识
     */
    public static final int MODULE_EQUIP = 2;

    /**
     * 记录模块标识
     */
    public static final int MODULE_SPORT_RECORD= 3;

    /**
     * 活动模块标识
     */
    public static final int MODULE_ACTIVITY= 4;

    /**
     * 线程队列标识符
     */
    String REDIS_THREADH_QUEUE = "tq";

    /**
     * 存储当前登录用户id的字段名
     */
    String CURRENT_USER_PHONE = "CURRENT_USER_PHONE";

    /**
     * 存放Authorization的header字段
     */
    String AUTHORIZATION = "authorization";

    String OTHER_TOKEN = "tiyujia2016";

    String VENUE_REDIS_List_KEY = "venue_redis_list_key";

}
