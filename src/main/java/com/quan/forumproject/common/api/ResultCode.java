package com.quan.forumproject.common.api;


import org.springframework.stereotype.Component;

/**
 * @ClassName: ResultCode
 * @Description: 响应信息封装类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 10:10
 */


public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token失效"),
    FORBIDDEN(403, "没有相关权限");


    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
