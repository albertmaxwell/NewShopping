package com.alibaba.shopping.common.emun;

/**
 * @author 金海洋
 * @date 2019/8/18  -12:47
 */
public enum ErrorCode {

	SUCCESS(10000, "成功"),
	PARAM_ERROR(20000, "参数异常"),
	LOGIC_ERROR(30000, "逻辑错误"),
	RUNTIME_ERROR(40000, "服务器错误"),
	ERROR(50000, "内部错误"),
	LOGIC_NOLOGIN_ERROR(30100, "用户未登录"),
	LOGIC_ACCESS_NOT_AUTH(30200, "没有访问权限");

	private int code;
	private String value;

	private ErrorCode(int code, String value) {
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return this.code;
	}

	public String getValue() {
		return this.value;
	}


}
