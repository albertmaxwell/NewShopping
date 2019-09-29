package com.alibaba.shopping.shopping_bean.bean;

/**
 * 商品分类
 * @author 金海洋
 * @date 2019/9/29  -14:05
 */
public class GoodsClass {

	//商品分类id
	private String categoryId;
    //分类名称
	private String categoryName;
    //分类编号
	private String categoryCode;
    //父级id
	private String parentId;
    //等级
	private String categoryLever;
    //状态
	private String categoryStatus;
    //改动时间
	private String modifiedTime;
    //是否展示
	private String display;
    //是否推荐
	private String isRecommend;
    //描述
	private String goodsDesc;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCategoryLever() {
		return categoryLever;
	}

	public void setCategoryLever(String categoryLever) {
		this.categoryLever = categoryLever;
	}

	public String getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(String isRecommend) {
		this.isRecommend = isRecommend;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
}
