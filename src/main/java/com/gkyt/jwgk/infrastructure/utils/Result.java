package com.gkyt.jwgk.infrastructure.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private T data;
    private Integer code;
    private String msg;

    public static <T> Result<T> succeed(T model, String msg) {
        return succeedWith(model, CodeEnum.SUCCESS.getCode(), msg == null ? "success" : msg);
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(null, CodeEnum.FAILURE.getCode(), msg == null ? "failed" : msg);
    }

    private static <T> Result<T> succeedWith(T data, Integer code, String msg) {
        return new Result<>(data, code, msg);
    }

    private static <T> Result<T> failedWith(T data, Integer code, String msg) {
        return new Result<>(data, code, msg);
    }
}
