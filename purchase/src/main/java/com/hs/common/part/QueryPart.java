package com.hs.common.part;

import lombok.Data;

/**
 * @author 韩善成
 * @data 2023/6/7 23:38
 */
@Data
public class QueryPart {

    private String code;

    private String name;

    //查询页数
    private Integer currentPage;
    //每页的条数
    private Integer pageSize;
    //分页的第一个参数
    private Integer offSize;
}
