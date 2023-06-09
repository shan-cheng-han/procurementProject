package com.hs.bean.planCategory;

import lombok.Data;

/**
 * @author 韩善成
 * @data 2023/4/24 21:57
 */
@Data
public class QueryPlanCategoryVo {
    //查询页数
    private Integer currentPage;

    //查询计划大类编码
    private String code;

    //查询计划大类名称
    private String name;

    //查询计划大类状态
    private Boolean status;

    //每页的条数
    private Integer pageSize;

    //分页的第一个参数
    private Integer offSize;
}
