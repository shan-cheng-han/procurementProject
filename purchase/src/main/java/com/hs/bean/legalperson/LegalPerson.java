package com.hs.bean.legalperson;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/5/12 4:23
 */
@Data
public class LegalPerson {

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

    //用户名称
    private String userName;
}
