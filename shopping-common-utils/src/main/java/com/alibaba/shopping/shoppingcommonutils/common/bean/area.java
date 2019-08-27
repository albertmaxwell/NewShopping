package com.alibaba.shopping.shoppingcommonutils.common.bean;

import java.io.Serializable;

/**
 * @author 金海洋
 * @date 2019/8/27  -10:05
 */
public class area implements Serializable {

	private  String id;
	private  String pid;
	private  String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
