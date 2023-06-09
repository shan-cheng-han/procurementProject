package com.hs.bean.spare;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/5/11 9:43
 */
@Data
public class QuerySpareVo {
    //查询页数
    private Integer currentPage;

    //查询备件编码
    private String code;

    //查询备件名称
    private String name;

    //查询备件状态
    private Boolean status;

    //查询备件状态
    private String statusName;

    //查询备件小类名称
    private Integer subClassId;
    private String subClassName;

    //查询计划大类名称
    private Integer planClassId;
    private String planClassName;

    //查询法人名称
    private String legalPersonName;

    //每页的条数
    private Integer pageSize;

    //分页的第一个参数
    private Integer offSize;




    //备件id
    private Integer id;

    //计划大类id
    private Integer planCategoryId;

    //备件小类id
    private Integer subclassId;

    private Integer version;

    private String createMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    private String modifyMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;
}
