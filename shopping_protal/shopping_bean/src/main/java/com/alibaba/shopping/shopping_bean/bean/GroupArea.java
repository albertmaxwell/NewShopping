package com.alibaba.shopping.shopping_bean.bean;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/29  -15:35
 */
public class GroupArea {

	//团购地区名称
	private String ga_name;
	//团购地区序列
	private int ga_sequence;

	//团购父地区
	private GroupArea parent;

	//团购子地区
	private List<GroupArea> childs = new ArrayList();
	//团购地区等级
	private int ga_level;

	public int getGa_level(){
		return this.ga_level;
	}

	public void setGa_level(int ga_level){
		this.ga_level = ga_level;
	}

	public String getGa_name(){
		return this.ga_name;
	}

	public void setGa_name(String ga_name){
		this.ga_name = ga_name;
	}

	public int getGa_sequence(){
		return this.ga_sequence;
	}

	public void setGa_sequence(int ga_sequence){
		this.ga_sequence = ga_sequence;
	}

	public GroupArea getParent(){
		return this.parent;
	}

	public void setParent(GroupArea parent){
		this.parent = parent;
	}

	public List<GroupArea> getChilds(){
		return this.childs;
	}

	public void setChilds(List<GroupArea> childs){
		this.childs = childs;
	}


}
