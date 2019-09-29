package com.alibaba.shopping.shopping_bean.bean;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:58
 */
public class GoodsSpecProperty {

	//序列
	private int sequence;
	//值
	private String value;
	//规格图
	private Accessory specImage;
	//商品规格
	private GoodsSpecification spec;

	public int getSequence(){
		return this.sequence;
	}

	public void setSequence(int sequence){
		this.sequence = sequence;
	}

	public String getValue(){
		return this.value;
	}

	public void setValue(String value){
		this.value = value;
	}

	public Accessory getSpecImage(){
		return this.specImage;
	}

	public void setSpecImage(Accessory specImage){
		this.specImage = specImage;
	}

	public GoodsSpecification getSpec(){
		return this.spec;
	}

	public void setSpec(GoodsSpecification spec){
		this.spec = spec;
	}

}
