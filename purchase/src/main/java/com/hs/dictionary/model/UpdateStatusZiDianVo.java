package com.hs.dictionary.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/7 5:22
 */
@Data
public class UpdateStatusZiDianVo {

    private Integer id;

    private String code;

    private String name;

    private String remark;

    private Boolean status;

    private Boolean isParent;

    private String parentCode;

    List<ZiDianVo> sonList;


}
