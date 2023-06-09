package com.hs.common.enumc;

/**
 * @author 韩善成
 * @data 2023/6/6 10:47
 */
public enum StatusEnum {
    QIYON(1,"启用"),JINYON(0,"禁用"),QUANBU(2,"全部");

    private String statusName;

    private Integer value;

    StatusEnum( Integer value,String statusName){
        this.value = value;
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public Integer getValue() {
        return value;
    }
}
