package com.alibaba.shopping.shopping_bean.bean;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/29  -15:30
 */
public class UserGoodsClass {

	//类型名称
	private String className;
	//序列
	private int sequence;
	//是否展示
	private boolean display;
	//等级
	private int level;

	//用户父类型
	private UserGoodsClass parent;

	//用户自类型
	private List<UserGoodsClass> childs = new ArrayList();

	//商品列表
	private List<Goods> goods_list = new ArrayList();

	//用户
	private User user;

	public List<Goods> getGoods_list(){
		return this.goods_list;
	}

	public void setGoods_list(List<Goods> goods_list){
		this.goods_list = goods_list;
	}

	public String getClassName(){
		return this.className;
	}

	public void setClassName(String className){
		this.className = className;
	}

	public int getSequence(){
		return this.sequence;
	}

	public void setSequence(int sequence){
		this.sequence = sequence;
	}

	public boolean isDisplay(){
		return this.display;
	}

	public void setDisplay(boolean display){
		this.display = display;
	}

	public int getLevel(){
		return this.level;
	}

	public void setLevel(int level){
		this.level = level;
	}

	public UserGoodsClass getParent(){
		return this.parent;
	}

	public void setParent(UserGoodsClass parent){
		this.parent = parent;
	}

	public List<UserGoodsClass> getChilds(){
		return this.childs;
	}

	public void setChilds(List<UserGoodsClass> childs){
		this.childs = childs;
	}

	public User getUser(){
		return this.user;
	}

	public void setUser(User user){
		this.user = user;
	}


}
