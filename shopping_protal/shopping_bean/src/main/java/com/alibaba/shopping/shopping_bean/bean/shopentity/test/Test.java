package com.alibaba.shopping.shopping_bean.bean.shopentity.test;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 金海洋
 * @date 2019/10/1  -12:38
 */
@Entity
@Table(name = "test")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
