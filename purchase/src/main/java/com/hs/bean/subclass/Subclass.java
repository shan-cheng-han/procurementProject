package com.hs.bean.subclass;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author 韩善成
 * @data 2023/4/23 14:34
 * 备件小类
 */
@Data
public class Subclass {

    private Integer id;

    @NotBlank(message = "备件小类编码不能为空")
    private String code;

    @NotBlank(message = "备件小类名称不能为空")
    private String name;

    private Boolean status;

    private String statusName;

    private String remark;

    private Integer version;

    private String createMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    private String modifyMan;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyTime;

}
