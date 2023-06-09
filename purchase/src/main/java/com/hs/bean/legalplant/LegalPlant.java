package com.hs.bean.legalplant;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/5/12 5:59
 */
@Data
public class LegalPlant {

    private Integer id;

    private String legalPlantCode;

    private String legalPlantDec;

    private String legalPersonCode;

    private String legalPersonName;

    private Boolean enabled;

    private Integer version;

    private String createMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    private String modifyMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;
}
