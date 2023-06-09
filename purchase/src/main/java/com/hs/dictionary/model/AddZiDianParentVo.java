package com.hs.dictionary.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/7 5:22
 */
@Data
public class AddZiDianParentVo {


    @NotBlank(message = "编码不能为空")
    private String code;

    @NotBlank(message = "名称不能为空")
    private String name;

    private String remark;

    @NotNull(message = "状态不能为空")
    private Boolean status;


}
