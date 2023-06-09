package com.hs.common.enumc;

/**
 * @author 韩善成
 * @data 2023/6/6 12:03
 */
public enum PriceTypeEnum {

    DIYIJIAGEFENLEI(1,"第一价格分类");

    private String priceType;
    private Integer value;

    PriceTypeEnum(Integer value,String priceType) {
        this.priceType = priceType;
        this.value = value;
    }

    public String getPriceType() {
        return priceType;
    }

    public Integer getValue() {
        return value;
    }
}
