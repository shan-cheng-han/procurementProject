package com.hs.bean.sparecostprice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/6 12:20
 */
@Data
public class AddSpareCostPriceVo {

    private Integer id;

    private String legalPersonCode;

    private String materialCode;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date startTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;

    private String priceTypeName;

    private String currencyCodeName;

    private String currencyCode;

    private BigDecimal price;

    private String legalPlantCode;

    private String remark;

    private Byte status;


    private Integer version;

    private String creatorName;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    private String modifyMan;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modifyTime;

    private String taxDec;

    private String materialName;

    private String legalPersonName;


}
