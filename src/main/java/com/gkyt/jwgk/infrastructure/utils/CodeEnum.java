package com.gkyt.jwgk.infrastructure.utils;

public enum CodeEnum {
    SUCCESS(0),
    FAILURE(1);

    private Integer code;

    CodeEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
