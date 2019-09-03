package com.alibaba.shopping.common.common.enums;

/**
 * 错误枚举
 * 1开头代表成功
 * 2开头代表传参导致业务异常
 * 3开头代表业务处理时的问题
 * 4开头代表运行时异常
 * 5开头代表内部异常
 * @author 盛凯 2018-10-31
 *
 */
public enum ErrorCode {

	SUCCESS(10000, "成功"),
	PARAM_ERROR(20000, "参数异常"),
	LOGIC_ERROR(30000, "逻辑错误"),
	RUNTIME_ERROR(40000, "服务器错误"),
	ERROR(50000, "内部错误"),
	

	LOGIC_NOLOGIN_ERROR(30100, "用户未登录"),
	LOGIC_ACCESS_NOT_AUTH(30200, "没有访问权限"),
	;
	
	private int code;
	private String value;
	
	ErrorCode(int code, String value) { 
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