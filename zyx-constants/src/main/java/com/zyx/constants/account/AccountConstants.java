package com.zyx.constants.account;

import com.sun.prism.impl.BaseContext;
import com.zyx.constants.Constants;

/**
 * Created by Rainbow on 2016/11/1.
 */
public interface AccountConstants extends Constants {
    /**
     * 未登录
     */
    int ACCOUNT_ERROR_CODE_40000 = 40000;
    String ACCOUNT_ERROR_CODE_40000_MSG = "用户token已经失效，请重新登录";

    /**
     * 用户名密码错误
     */
    int ACCOUNT_ERROR_CODE_40001 = 40001;
    String ACCOUNT_ERROR_CODE_40001_MSG = "用户名、密码错误";

    /**
     * 用户信息修改失败
     */
    int ACCOUNT_ERROR_CODE_40002 = 40002;
    String ACCOUNT_ERROR_CODE_40002_MSG = "用户信息修改失败";

    /**
     * 手机号码未注册
     */
    int ACCOUNT_ERROR_CODE_40003 = 40003;
    String ACCOUNT_ERROR_CODE_40003_MSG = "手机号码未注册";

    /**
     * 重复登录
     */
    int ACCOUNT_ERROR_CODE_40004 = 40004;
    String ACCOUNT_ERROR_CODE_40004_MSG = "重复登录";

    /**
     * 手机号已注册
     */
    int ACCOUNT_ERROR_CODE_40005 = 40005;
    String ACCOUNT_ERROR_CODE_40005_MSG = "手机号已注册";

    /**
     * 验证码输入错误
     */
    int ACCOUNT_ERROR_CODE_40006 = 40006;
    String ACCOUNT_ERROR_CODE_40006_MSG = "验证码输入错误";

    /**
     * 短信发送失败，短信发送过于频繁！！！
     */
    int ACCOUNT_ERROR_CODE_40007 = 40007;
    String ACCOUNT_ERROR_CODE_40007_MSG = "短信发送失败，短信发送过于频繁！！！";

    /**
     * 短信发送失败，未知错误！！！
     */
    int ACCOUNT_ERROR_CODE_40008 = 40008;
    String ACCOUNT_ERROR_CODE_40008_MSG = "短信发送失败，未知错误！！！";

    /**
     * 短信发送失败，短信服务器异常！！！
     */
    int ACCOUNT_ERROR_CODE_40009 = 40009;
    String ACCOUNT_ERROR_CODE_40009_MSG = "短信发送失败，短信服务器异常！！！";

    /**
     * 服务器DB错误，注册用户失败！！！
     */
    int ACCOUNT_ERROR_CODE_40010 = 40010;
    String ACCOUNT_ERROR_CODE_40010_MSG = "服务器DB错误，注册用户失败！！！";

    /**
     * 非法操作！！！验证码不存在
     */
    int ACCOUNT_ERROR_CODE_40011 = 40011;
    String ACCOUNT_ERROR_CODE_40011_MSG = "非法操作！！！验证码不存在";

    /**
     * 两次输入的密码不正确
     */
    int ACCOUNT_ERROR_CODE_40012 = 40012;
    String ACCOUNT_ERROR_CODE_40012_MSG = "两次输入的密码不正确！！！";

    /**
     * 注册成功
     */
    int ACCOUNT_ERROR_CODE_40013 = 40013;
    String ACCOUNT_SUCCESS_CODE_40013_MSG = "注册成功！！！";

    /**
     * 手机号码不正确
     */
    int ACCOUNT_ERROR_CODE_40014 = 40014;
    String ACCOUNT_ERROR_CODE_40014_MSG = "手机号码不正确！！！";

    /**
     * 用户提交审核失败
     */
    int ACCOUNT_ERROR_CODE_40015 = 40015;
    String ACCOUNT_ERROR_CODE_40015_MSG = "用户提交审核失败！！！";

    /**
     * 发送验证码失败，手机号格式有误
     */
    int ACCOUNT_ERROR_CODE_40100 = 40100;
    String ACCOUNT_ERROR_CODE_40100_MSG = "发送验证码失败，手机号格式有误";

    /**
     * 发送验证码失败，短信类型设置有误
     */
    int ACCOUNT_ERROR_CODE_40101 = 40101;
    String ACCOUNT_ERROR_CODE_40101_MSG = "发送验证码失败，短信类型设置有误";


    /**
     * 该用户第一次签到，插入数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_40200 = 40200;
    String ACCOUNT_ERROR_CODE_40200_MSG = "该用户第一次签到，插入数据失败！！！";

    /**
     * 该用户今天已经签过到了，更新数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_40201 = 40201;
    String ACCOUNT_ERROR_CODE_40201_MSG = "该用户今天已经签过到了，更新数据失败！！！";

    /**
     * 该用户暂无签到数据！！！
     */
    int ACCOUNT_ERROR_CODE_40202 = 40202;
    String ACCOUNT_ERROR_CODE_40202_MSG = "该用户暂无签到数据！！！";

    /**
     * 签到失败，更新数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_40203 = 40203;
    String ACCOUNT_ERROR_CODE_40203_MSG = "签到失败，更新数据失败！！！";

    /**
     * 无数据，查询失败！！！
     */
    int ACCOUNT_ERROR_CODE_40300 = 40300;
    String ACCOUNT_ERROR_CODE_40300_MSG = "无数据，查询失败！！！";

    /**
     * 用户ID与用户不匹配，查询失败！！！
     */
    int ACCOUNT_ERROR_CODE_40301 = 40301;
    String ACCOUNT_ERROR_CODE_40301_MSG = "用户ID与用户不匹配，查询失败！！！";

    /**
     * 服务器DB错误，插入数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_40400 = 40400;
    String ACCOUNT_ERROR_CODE_40400_MSG = "服务器DB错误，插入数据失败！！！";

    /**
     * 服务器DB错误，删除数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_40401 = 40401;
    String ACCOUNT_ERROR_CODE_40401_MSG = "服务器DB错误，删除数据失败！！！";

    /**
     * 服务器DB错误，修改数据失败！！！
     */
    int ACCOUNT_ERROR_CODE_40402 = 40402;
    String ACCOUNT_ERROR_CODE_40402_MSG = "服务器DB错误，修改数据失败！！！";

    /**
     * ---------------------------常量---------------------------------------------
     */

    // ----------------------首推开始----------------------
    int USER_DEVA_MODEL = 5;

    String TYJ_DEVA = "TYJ_DEVA";

    String TYJ_USER_DEVA = "TYJ_USER_DEVA";
    // ----------------------首推结束-----------------------

    //----------------------REDIS参数开始-------------------
    /**
     * token键
     */
    String REDIS_KEY_TYJ_TOKEN = "TYJ_TOKEN:";

    /**
     * phone键
     */
    String REDIS_KEY_TYJ_PHONE = "TYJ_PHONE:";

    /**
     * 验证码键
     */
    String REDIS_KEY_TYJ_PHONE_CODE = "TYJ_PHONE_CODE:";

    //----------------------REDIS参数结束-------------------

    String TIMESTAMP_LONG = "timestamp_long";

    String TIMESTAMP_STRING = "timestamp_string";

    String MARK_INFO = "mark_info";

    /**
     * 注册-发验证码
     */
    String SEND_REGISTER = "register";

    /**
     * 公共-发验证码
     */
    String SEND_PUBLIC = "public";
}
