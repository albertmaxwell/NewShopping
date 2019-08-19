package com.alibaba.shopping.shopping_bean.bean;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 金海洋
 * @describe
 * @date 2019/8/10  13:46
 */
@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class UserMembers implements Serializable {

	private String id;

	private String username;

	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
