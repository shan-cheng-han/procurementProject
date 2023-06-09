package com.hs.bean.fazhi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/6/9 10:57
 */
@Data
public class Fazhi {

    private Integer id;

    private Integer fazhiNum;

    private String remark;

    private String createMan;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    private String modifyMan;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modifyTime;

    private Integer version;

    private String legalPersonCode;

    private String spareCode;
}
