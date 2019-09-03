package com.alibaba.shopping.common.common.exception;


import com.alibaba.shopping.common.common.enums.ErrorCode;
import com.alibaba.shopping.common.common.vo.ResultVo;
import com.alibaba.shopping.common.common.vo.factory.ResultVoFactory;

public class ResultException extends Exception {

	private ResultVo resultVo;
	
	public ResultException() {
		this.resultVo = new ResultVo();
		this.resultVo.setOk(false);
		this.resultVo.setCode(ErrorCode.ERROR.getCode());
	}
	
	public ResultException(int code) {
		this.resultVo = ResultVoFactory.build(code, null, null);
	}

	public ResultException(int code, String message) {
		this.resultVo = ResultVoFactory.build(code, null, message);
	}
	
	public ResultVo getResultVO() {
		return this.resultVo;
	}
}
