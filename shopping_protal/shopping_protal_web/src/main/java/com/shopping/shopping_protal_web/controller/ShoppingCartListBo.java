package com.shopping.shopping_protal_web.controller;

/**
 * 购物车列表
 * @author 金海洋
 * @date 2019/9/29  -11:13
 */
public class ShoppingCartListBo {

	//商品图片
	private String mainPicUrl;
    //商品描述
	private String productDes;
    //商品样式
	private String productStyle;
    //单个商品的价格
	private String singlePrice;
    //购买数量
	private String buyNumber;
    //合计价格
	private String allSingle;

	public String getMainPicUrl() {
		return mainPicUrl;
	}

	public void setMainPicUrl(String mainPicUrl) {
		this.mainPicUrl = mainPicUrl;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public String getProductStyle() {
		return productStyle;
	}

	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}

	public String getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}

	public String getBuyNumber() {
		return buyNumber;
	}

	public void setBuyNumber(String buyNumber) {
		this.buyNumber = buyNumber;
	}

	public String getAllSingle() {
		return allSingle;
	}

	public void setAllSingle(String allSingle) {
		this.allSingle = allSingle;
	}
}
