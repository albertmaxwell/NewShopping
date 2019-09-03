package com.alibaba.shopping.common.common.vo;


import com.alibaba.shopping.common.common.enums.ErrorCode;

public class ResultVo<T> {

	private int code = ErrorCode.SUCCESS.getCode();
	private T data;
	private String message;
	private boolean ok;
	
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
