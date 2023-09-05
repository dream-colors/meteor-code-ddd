package com.meteor.ddd.interfaces.dto.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Data
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 89562810837249881L;

    private Integer code;
    private Boolean success;
    private String message;
    private T data;

    public CommonResponse(Boolean success) {
        this.success = success;
    }

    public CommonResponse(Integer code, Boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public static <T> CommonResponse<T> success(T data) {
        CommonResponse<T> response = new CommonResponse<>(Boolean.TRUE);
        response.setCode(200);
        response.setData(data);
        return response;
    }

    public static CommonResponse<Void> failure(String message) {
        CommonResponse<Void> response = new CommonResponse<>(Boolean.FALSE);
        response.setCode(500);
        response.setMessage(message);
        return response;
    }
}
