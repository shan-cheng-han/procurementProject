package com.hs.bean;

import lombok.Data;

/**
 * @author 韩善成
 * @data 2023/4/19 10:56
 * 接收备件小类查询界面的实体类
 */
@Data
public class QuerySparePartsSubcategoryVo {

    //查询页数
    private Integer currentPage;

    //查询的id(以防不备先写上)
    private Integer id;

    //查询备件小类编码
    private String subclassEncoding;

    //查询备件小类名称
    private String subclassName;

    //查询备件小类状态
    private String status;

    //每页的条数
    private Integer pageSize;

    //分页的第一个参数
    private Integer offSize;
}
