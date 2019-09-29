package com.alibaba.shopping.shopping_bean.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/29  -15:38
 */
public class GroupClass {

	//分组类型名称
	private String gc_name;
	//分组类型序列
	private int gc_sequence;

	//分组父类型
	private GroupClass parent;

	//分组子类型
	private List<GroupClass> childs = new ArrayList();

	private List<GroupGoods> ggs = new ArrayList();
	//分组类型等级
	private int gc_level;

	public List<GroupGoods> getGgs(){
		return this.ggs;
	}

	public void setGgs(List<GroupGoods> ggs){
		this.ggs = ggs;
	}

	public int getGc_level(){
		return this.gc_level;
	}

	public void setGc_level(int gc_level){
		this.gc_level = gc_level;
	}

	public String getGc_name(){
		return this.gc_name;
	}

	public void setGc_name(String gc_name){
		this.gc_name = gc_name;
	}

	public int getGc_sequence(){
		return this.gc_sequence;
	}

	public void setGc_sequence(int gc_sequence){
		this.gc_sequence = gc_sequence;
	}

	public GroupClass getParent(){
		return this.parent;
	}

	public void setParent(GroupClass parent){
		this.parent = parent;
	}

	public List<GroupClass> getChilds(){
		return this.childs;
	}

	public void setChilds(List<GroupClass> childs){
		this.childs = childs;
	}

}
