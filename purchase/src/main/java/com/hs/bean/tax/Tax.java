package com.hs.bean.tax;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/5 13:15
 */
@Data
public class Tax {
    private Integer id;

    private String taxCode;

    private String taxDec;

    private Integer tax;

    private Byte status;

    private String statusName;

    private Integer version;

    private String createMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    private String modifyMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;

    //查询页数
    private Integer currentPage;

    //每页的条数
    private Integer pageSize;

    //分页的第一个参数
    private Integer offSize;
}
