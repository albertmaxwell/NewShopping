package com.alibaba.shopping.common.exception;

import com.alibaba.shopping.common.emun.ErrorCode;
import com.alibaba.shopping.common.vo.ResultVo;
import com.alibaba.shopping.common.vo.ResultVoFactory.ResultVoFactory;

/**
 * @author 金海洋
 * @date 2019/8/18  -12:45
 */
public class ResultException extends Exception {
		private ResultVo resultVo;

    public ResultException() {
			this.resultVo = new ResultVo();
			this.resultVo.setOk(false);
			this.resultVo.setCode(ErrorCode.ERROR.getCode());
		}

    public ResultException(int code) {
			this.resultVo = ResultVoFactory.build(code, (Object)null, (String)null);
		}

    public ResultException(int code, String message) {
			this.resultVo = ResultVoFactory.build(code, (Object)null, message);
		}

		public ResultVo getResultVO() {
			return this.resultVo;
		}


}
