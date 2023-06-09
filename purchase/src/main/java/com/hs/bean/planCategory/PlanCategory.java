package com.hs.bean.planCategory;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/4/24 11:36
 * 计划大类
 */
@Data
public class PlanCategory {

    private Integer id;

    private String code;

    private String name;

    private String remark;

    private Boolean status;

    private Integer version;

    private String createMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    private String modifyMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;
}
