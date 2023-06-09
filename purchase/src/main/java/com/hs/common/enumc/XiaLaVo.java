package com.hs.common.enumc;

import lombok.Data;

/**
 * @author 韩善成
 * @data 2023/6/6 12:48
 */
@Data
public class XiaLaVo {

    private Integer value;

    private String label;

    public XiaLaVo(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

}
