package com.alibaba.shopping.common.vo.ResultVoFactory;

import com.alibaba.shopping.common.emun.ErrorCode;
import com.alibaba.shopping.common.vo.ResultVo;

/**
 * @author 金海洋
 * @date 2019/8/18  -12:49
 */
public class ResultVoFactory {

	public ResultVoFactory() {
	}

	public static ResultVo success(Object data, String message) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(ErrorCode.SUCCESS.getCode());
		resultVo.setData(data);
		resultVo.setMessage(message);
		resultVo.setOk(true);
		return resultVo;
	}

	public static ResultVo build(int code, Object data, String message) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(code);
		resultVo.setData(data);
		resultVo.setMessage(message);
		if (code == ErrorCode.SUCCESS.getCode()) {
			resultVo.setOk(true);
		} else {
			resultVo.setOk(false);
		}

		return resultVo;
	}

	public static ResultVo build(int code, Object data, String message, boolean ok) {
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(code);
		resultVo.setData(data);
		resultVo.setMessage(message);
		resultVo.setOk(ok);
		return resultVo;
	}


}
