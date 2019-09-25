package com.alibaba.shopping.shoppingcommonutils.common.utils;


import com.alibaba.shopping.common.bean.TSUser;
import com.alibaba.shopping.common.entity.TSFunction;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/8/29  -14:16
 */
public class Client implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private TSUser user;

	private Map<String, TSFunction> functions;
	private Map<Integer, List<TSFunction>> functionMap;

	public TSUser getUser() {
		return user;
	}

	public void setUser(TSUser user) {
		this.user = user;
	}

	/**
	 * 用户IP
	 */
	private java.lang.String ip;
	/**
	 * 登录时间
	 */
	private java.util.Date logindatetime;

	public java.lang.String getIp() {
		return ip;
	}

	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}

	public java.util.Date getLogindatetime() {
		return logindatetime;
	}

	public void setLogindatetime(java.util.Date logindatetime) {
		this.logindatetime = logindatetime;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Map<String, TSFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(Map<String, TSFunction> functions) {
		this.functions = functions;
	}

	public Map<Integer, List<TSFunction>> getFunctionMap() {
		return functionMap;
	}

	public void setFunctionMap(Map<Integer, List<TSFunction>> functionMap) {
		this.functionMap = functionMap;
	}
}
