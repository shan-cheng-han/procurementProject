package com.hs.bean;

import com.sun.xml.internal.ws.resources.XmlmessageMessages;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 韩善成
 * @data 2023/4/18 18:05
 */
@Data
public class SparePartsSubcategory {


    private int id;
    @NotBlank(message = "备件小类编码不能为空")
    private String subclassEncoding;

    @NotBlank(message = "备件小类名称不能为空")
    private String subclassName;

    @NotBlank(message = "备件小类状态不能为空")
    private String status;

    private String description;

}
