package com.hs.bean.fazhi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/9 10:57
 */
@Data
public class QueryFazhiVo {

    private String legalPersonCode;

    private String spareCode;

    private String subclassCode;

    private Integer minFazhiNum;

    private Integer maxFazhiNum;

    private Integer modifyMan;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date minModifyTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date maxModifyTime;

    private Integer pageIndex;

    private Integer pageSize;

    //分页第一条参数
    private Integer offSize;

}
