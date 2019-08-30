package com.alibaba.shopping.shoppingcommonutils.common.utils;


import com.alibaba.shopping.common.bean.TSUser;

import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/8/29  -14:16
 */
public class Client implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private TSUser user;

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




}
