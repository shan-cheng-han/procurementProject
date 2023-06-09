package com.hs.bean.spare;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/11 11:18
 */
@Data
public class AddSpareVo {

    private int id;

    @NotBlank(message = "备件编码不能为空")
    private String code;

    @NotBlank(message = "备件名称不能为空")
    private String name;

    private Boolean status;

    @NotNull(message = "计划大类不能为空")
    private Integer planClassId;

    @NotNull(message = "备件小类不能为空")
    private Integer subClassId;

    //法人信息
    private List<Integer> legalPersonIds;



    private Integer version;

    private String createMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    private String modifyMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;
}
