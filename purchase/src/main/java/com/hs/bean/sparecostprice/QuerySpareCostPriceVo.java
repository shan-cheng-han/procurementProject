package com.hs.bean.sparecostprice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/6 12:20
 */
@Data
public class QuerySpareCostPriceVo {

    private Integer id;

    @NotBlank(message = "ErrorMessageEnum.MINGCHENGBUNENGWEIKONG")
    private String legalPersonCode;

    //备件编码
    private String materialCode;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date priceStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date priceEndTime;

    private String priceType;

    //货币类别
    private String currencyCodeName;

    private BigDecimal price;

    private String legalPlantCode;

    private String remark;

    private Byte status;

    private String statusName;

    private Integer version;

    private String createMan;

    private Date createTime;

    private String modifyMan;

    private Date modifyTime;

    private String taxType;

    //查询页数
    private Integer currentPage;

    //每页的条数
    private Integer pageSize;

    //分页的第一个参数
    private Integer offSize;

    //备件名称
    private String spareName;

    //工厂(描述)
    private String legalPlantDec;

    //法人名称
    private String legalPersonName;
}
