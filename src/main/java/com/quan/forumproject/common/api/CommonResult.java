package com.quan.forumproject.common.api;

import org.springframework.stereotype.Component;

/**
 * @ClassName: CommonResult
 * @Description: 统一信息返回类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/27 10:08
 */

@Component
public class CommonResult<T> {

    private long code;
    private String message;
    private T data;

    public CommonResult() {
    }

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * @Description //TODO 成功返回结果
     * @Date 15:36 2022/1/30
     * @Param data获取的数据
     **/
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * @Description //TODO 成功返回结果
     * @Date 15:37 2022/1/30
     * @Param [data, message]
     **/
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * @Author Hilda
     * @Description //TODO 成功返回信息
     * @Date 15:33 2022/2/27
     * @Param [message]
     * @returnValue com.quan.forumproject.common.api.CommonResult<T>
     **/
    public static <T> CommonResult<T> success(String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, null);
    }
    

    /**
     * @Description //TODO 失败返回结果
     * @Date 15:38 2022/1/30
     * @Param [errorCode]
     **/
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * @Description //TODO 失败返回结果
     * @Date 15:39 2022/1/30
     * @Param [message]
     **/
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * @Author Hilda
     * @Description //TODO 失败返回结果，直接调用已有方法
     * @Date 15:42 2022/1/30
     * **/
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }


    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResult<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }



    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
