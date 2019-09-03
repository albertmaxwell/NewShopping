package com.alibaba.shopping.common.common.vo.factory;

import com.alibaba.shopping.common.common.enums.ErrorCode;
import com.alibaba.shopping.common.common.vo.ResultVo;


public class ResultVoFactory {

	/**
	 * 成功
	 * @param data
	 * @param message
	 * @return
	 */
	public static ResultVo success(Object data, String message) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(ErrorCode.SUCCESS.getCode());
		resultVo.setData(data);
		resultVo.setMessage(message);
		resultVo.setOk(true);
		return resultVo;
	}
	
	/**
	 * 生成
	 * @param code
	 * @param data
	 * @param message
	 * @return
	 */
	public static ResultVo build(int code, Object data, String message) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(code);
		resultVo.setData(data);
		resultVo.setMessage(message);
		if(code == ErrorCode.SUCCESS.getCode()) {
			resultVo.setOk(true);
		} else {
			resultVo.setOk(false);
		}
		return resultVo;
	}
	
	/**
	 * 生成
	 * @param code
	 * @param data
	 * @param message
	 * @return
	 */
	public static ResultVo build(int code, Object data, String message, boolean ok) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(code);
		resultVo.setData(data);
		resultVo.setMessage(message);
		resultVo.setOk(ok);
		return resultVo;
	}
	 
}
