package com.alibaba.shopping.shopping_bean.bean;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:56
 */
public class GoodsTypeProperty {

	//序列
	private int sequence;
	//名称
	private String name;
	//值
	private String value;
	//是否展示
	private boolean display;

	//商品类型
	@ManyToOne(fetch = FetchType.LAZY)
	private GoodsType goodsType;

	public int getSequence(){
		return this.sequence;
	}

	public void setSequence(int sequence){
		this.sequence = sequence;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getValue(){
		return this.value;
	}

	public void setValue(String value){
		this.value = value;
	}

	public GoodsType getGoodsType(){
		return this.goodsType;
	}

	public void setGoodsType(GoodsType goodsType){
		this.goodsType = goodsType;
	}

	public boolean isDisplay(){
		return this.display;
	}

	public void setDisplay(boolean display){
		this.display = display;
	}


}
