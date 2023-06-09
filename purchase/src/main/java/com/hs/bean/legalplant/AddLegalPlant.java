package com.hs.bean.legalplant;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/5/13 5:34
 */
@Data
public class AddLegalPlant {


    private String legalPersonName;

    private String legalPersonCode;

    private Integer legalPersonId;

    @NotBlank(message = "工厂编码不能为空")
    private String legalPlantCode;

    @NotBlank(message = "工厂描述不能为空")
    private String legalPlantDec;

    @NotNull(message = "状态不能为空")
    private Boolean enabled;



    private String createMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    private String modifyMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;
}
