package com.hs.bean.legalplant;

import lombok.Data;

/**
 * @author 韩善成
 * @data 2023/5/12 6:21
 */
@Data
public class QueryLegalPlantVo {

    private String legalPlaneName;

    private String legalPlantDec;

    private Boolean enabled;

    private String legalPersonCode;

    private String legalPersonName;



    private String legalPlantCode;

    //查询页数
    private Integer currentPage;

    //每页的条数
    private Integer pageSize;

    //分页的第一个参数
    private Integer offSize;

}
