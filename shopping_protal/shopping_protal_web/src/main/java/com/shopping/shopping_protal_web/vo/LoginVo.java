package com.shopping.shopping_protal_web.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author 金海洋
 * @date 2019/8/18  -22:54
 */
public class LoginVo {

	//用户账号
	@ApiModelProperty(value = "用户账号", required = true, example = "jinhiayng")
	public String username;
	//用户密码
	@ApiModelProperty(value = "用户密码", required = true, example = "123456")
	public String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
