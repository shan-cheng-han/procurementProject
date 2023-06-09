package com.hs.common.enumc;

/**
 * @author 韩善成
 * @data 2023/6/6 12:16
 */
public enum ErrorMessageEnum {
    MINGCHENGBUNENGWEIKONG("名称不能为空"),BIANMABUNENGWEIKONG("编码不能为空");

    private String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
