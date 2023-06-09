package com.hs.bean.fazhi;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 韩善成
 * @data 2023/6/9 10:59
 */
@Data
public class AddFazhiVo {

    private Integer id;

    @NotNull(message = "数量阈值不能为空")
    private Integer fazhiNum;

    private String remark;

    private String legalPersonCode;

    private String spareCode;
}
