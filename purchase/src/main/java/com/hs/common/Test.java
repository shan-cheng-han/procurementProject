package com.hs.common;

import com.hs.bean.fazhi.QueryFazhiRe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/9 11:39
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<QueryFazhiRe> fazhiList = new ArrayList<>();
        for (QueryFazhiRe sc: fazhiList) {
            if (sc.getStatus() ==1){
                sc.setStatusName("启用");
            }else {
                sc.setStatusName("禁用");
            }
        }

    }
    private String ABC(Integer status,String statusName,String trueName,String falseName){
        if (status == 1){
            statusName = trueName;
        }else {
            statusName = falseName;
        }
        return statusName;
    }
}
