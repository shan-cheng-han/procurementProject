package com.hs.common.util;

/**
 * @author 韩善成
 * @data 2023/6/9 15:41
 */
public class StatusToStatusNameUtil {

    public static String statusToStatusNameUtil(Integer status,String statusName,String trueName,String falseName){
        if (status == 1){
            statusName = trueName;
        }else {
            statusName = falseName;
        }
        return statusName;
    }
}
