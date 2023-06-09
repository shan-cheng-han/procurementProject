package com.hs.bean.legalperson;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/5 10:41
 */
@Data
public class QueryLegalPersonVo {
    private Integer id;

    //法人编码
    private String legalPersonCode;

    //法人名称
    private String legalPersonName;

    private Boolean status;

    private String statusName;

    private Integer userId;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    private String createMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;

    private String modifyMan;

    private Integer version;

    private Integer spareCode;

    //查询页数
    private Integer currentPage;

    //每页的条数
    private Integer pageSize;

    //分页的第一个参数
    private Integer offSize;
}
