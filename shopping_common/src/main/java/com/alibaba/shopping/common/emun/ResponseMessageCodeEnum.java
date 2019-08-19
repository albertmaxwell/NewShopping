package com.alibaba.shopping.common.emun;

/**
 * Created by 李泽阳 on 2019/8/2
 */
public enum ResponseMessageCodeEnum {
    SUCCESS("0"),
    ERROR("-1"),
    VALID_ERROR("1000"),//校验失败
    SAVE_SUCCESS("r0001"),
    UPDATE_SUCCESS("r0002"),
    REMOVE_SUCCESS("r0003");

    private String code;

    ResponseMessageCodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
