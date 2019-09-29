package com.alibaba.shopping.shopping_bean.bean;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:57
 */
public class GoodsSpecification {

	//名称
	private String name;
	//序列
	private int sequence;
	//类型
	private String type;
	//类型集合
	private List<GoodsType> types = new ArrayList();
	//商品规格集合
	private List<GoodsSpecProperty> properties = new ArrayList();

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getSequence(){
		return this.sequence;
	}

	public void setSequence(int sequence){
		this.sequence = sequence;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type = type;
	}

	public List<GoodsType> getTypes(){
		return this.types;
	}

	public void setTypes(List<GoodsType> types){
		this.types = types;
	}

	public List<GoodsSpecProperty> getProperties(){
		return this.properties;
	}

	public void setProperties(List<GoodsSpecProperty> properties){
		this.properties = properties;
	}


}
