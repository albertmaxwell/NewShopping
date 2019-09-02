package com.alibaba.shopping.shopping_back_bean.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
public class UserMembers implements Serializable {

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", columnDefinition = "varchar(36)")
	@ApiModelProperty(value = "主键", required = false, example = "40287e816c6afe00016c6aff42e90001")
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
