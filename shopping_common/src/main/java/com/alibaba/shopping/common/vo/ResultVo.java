package com.alibaba.shopping.common.vo;

import com.alibaba.shopping.common.emun.ErrorCode;

/**
 * @author 金海洋
 * @date 2019/8/18  -12:46
 */
public class ResultVo<T> {

	private int code;
	private T data;
	private String message;
	private boolean ok;

	public ResultVo() {
		this.code = ErrorCode.SUCCESS.getCode();
	}

	public boolean isOk() {
		return this.ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
