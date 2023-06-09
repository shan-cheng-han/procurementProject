package com.hs.common.enumc;

/**
 * @author 韩善成
 * @data 2023/6/6 12:04
 */
public enum CurrencyEnum {
    RENMINGBI(1,"人民币"),MEIYUAN(2,"美元"),OUYUAN(3,"欧元");

    private Integer value;
    private String name;

    CurrencyEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
