package com.alibaba.shopping.common.exception;

/**
 * 根据具体业务抛出异常
 * @author 金海洋
 * @date 2019/8/24  -8:20
 */
public class BusinessException extends Exception{

	private static final long serialVersionUID = 1L;

	public BusinessException(String message){ super(message); }

	public BusinessException(Throwable cause) { super(cause); }

	public BusinessException(String message,Throwable cause) { super(message,cause); }


}
