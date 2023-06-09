package com.hs.common.too_old_too_out;

import lombok.Data;

/**
 * @author 韩善成
 * @data 2023/5/8 10:35
 */
@Data
public class StatusVo {

    //状态值
    private String label;

    //状态码
    private Integer value;

    public StatusVo(String label,Integer value){
        this.label = label;
        this.value = value;
    }
}
