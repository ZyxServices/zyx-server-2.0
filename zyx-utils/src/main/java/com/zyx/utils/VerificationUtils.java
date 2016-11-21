package com.zyx.utils;

import com.zyx.constants.Constants;

import java.util.Map;

/**
 * Created by Rainbow
 *  验证工具
 * @author SubDong
 * @version V2.0
 *          Copyright (c)2016 zyx-版权所有
 * @since 2016/11/21
 */
public class VerificationUtils {

    /**
     * 验证当前查询数据是否成功并且有数据
     * @param objectMap
     * @return
     */
    public static boolean dataSuccessAndDataNotNull(Map<String, Object> objectMap){
        if(objectMap.get(Constants.SUCCESS).equals("200") && objectMap.get(Constants.DATA) != null && !objectMap.get(Constants.DATA).equals("") && !objectMap.get(Constants.DATA).equals("null")){
            return true;
        }else{
            return false;
        }
    }

}
