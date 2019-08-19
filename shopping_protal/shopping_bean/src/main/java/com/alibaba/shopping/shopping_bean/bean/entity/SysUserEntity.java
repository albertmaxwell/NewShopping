package com.alibaba.shopping.shopping_bean.bean.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user", schema = "myjeecg", catalog = "")
public class SysUserEntity implements java.io.Serializable{

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @ApiModelProperty(value = "主键", hidden = false, example = "40287e816c6afe00016c6aff42e90001")
    private String id;

    /*登陆账号*/
	@ApiModelProperty(value = "登陆账号", required = true, example = "admin")
	@Column(name = "username", columnDefinition = "varchar(255)")
    private String username;
	/*登陆密码*/
	@ApiModelProperty(value = "登陆密码", required = true, example = "123456")
	@Column(name = "password", columnDefinition = "varchar(255)")
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
