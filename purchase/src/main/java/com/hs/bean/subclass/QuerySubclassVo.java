package com.hs.bean.subclass;

import lombok.Data;

/**
 * @author 韩善成
 * @data 2023/4/23 14:42
 */
@Data
public class QuerySubclassVo {
    //查询页数
    private Integer currentPage;

    //查询备件小类编码
    private String code;

    //查询备件小类名称
    private String name;

    //查询备件小类状态
    private Boolean status;

    //每页的条数
    private Integer pageSize;

    //分页的第一个参数
    private Integer offSize;
}
