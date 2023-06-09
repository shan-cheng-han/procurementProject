package com.hs.bean.fazhi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/9 10:57
 */
@Data
public class QueryFazhiRe {

    private String spareCode;

    private String spareName;

    private String spareUnit;

    private String subclassName;

    private Integer fazhiNum;

    private Integer status;
    private String statusName;

    private Integer isBorrow;
    private String isBorrowName;

    private Integer isSell;
    private String isSellName;

    private String remark;

    private String legalPersonName;

    private String createMan;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    private String modifyMan;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modifyTime;


}
