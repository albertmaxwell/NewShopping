package com.alibaba.shopping.common.response;

import com.alibaba.shopping.common.emun.ResponseMessageCodeEnum;

/**
 *
 *
 */
public class Result {
    public static final ResponseMessage RESPONSE_MESSAGE_SUCCESS = new ResponseMessage(ResponseMessageCodeEnum.SUCCESS, "成功", true, null);
    public static final ResponseMessage RESPONSE_MESSAGE_ERROR = new ResponseMessage(ResponseMessageCodeEnum.ERROR, "失败", false, null);

    //空返回success
    public static ResponseMessage success() {
        return RESPONSE_MESSAGE_SUCCESS;
    }

    //对象返回success
    public static <T> ResponseMessage<T> success(T t) {
        return new ResponseMessage(ResponseMessageCodeEnum.SUCCESS, "成功", true, t);
    }

    //按状态码返回success
    public static <T> ResponseMessage<T> success(ResponseMessageCodeEnum codeEnum, T t) {
        return new ResponseMessage(codeEnum, "", true, t);
    }

    //按自定义返回信息success
    public static <T> ResponseMessage<T> success(ResponseMessageCodeEnum codeEnum, String message, T t) {
        return new ResponseMessage(codeEnum, message, true, t);
    }

    //空返回error

    public static ResponseMessage error() {
        return error("失败");
    }

    public static ResponseMessage error(String message) {
        return error(ResponseMessageCodeEnum.ERROR, message);
    }

    public static ResponseMessage error(ResponseMessageCodeEnum codeEnum, String message) {
        return error(codeEnum, message, null);
    }

    public static <T> ResponseMessage<T> error(ResponseMessageCodeEnum codeEnum, String message, T t) {
        return new ResponseMessage(codeEnum, message, false, t);
    }

    /**
     * 校验失败信息
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage<T> error(T t) {
        return new ResponseMessage(ResponseMessageCodeEnum.VALID_ERROR, "校验失败", false, t);
    }

}
