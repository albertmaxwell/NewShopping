package com.alibaba.shopping.shopping_bean.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:54
 */
public class GoodsType {

	//名称
	private String name;
	//序列
	private int sequence;

	//商品规格集合
	private List<GoodsSpecification> gss = new ArrayList();

	//商品品牌集合
	private List<GoodsBrand> gbs = new ArrayList();

	//商品类型属性集合
	private List<GoodsTypeProperty> properties = new ArrayList();

	//商品类型
	private List<GoodsClass> gcs = new ArrayList();

	public List<GoodsClass> getGcs(){
		return this.gcs;
	}

	public void setGcs(List<GoodsClass> gcs){
		this.gcs = gcs;
	}

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

	public List<GoodsSpecification> getGss(){
		return this.gss;
	}

	public void setGss(List<GoodsSpecification> gss){
		this.gss = gss;
	}

	public List<GoodsBrand> getGbs(){
		return this.gbs;
	}

	public void setGbs(List<GoodsBrand> gbs){
		this.gbs = gbs;
	}

	public List<GoodsTypeProperty> getProperties(){
		return this.properties;
	}

	public void setProperties(List<GoodsTypeProperty> properties){
		this.properties = properties;
	}


}
