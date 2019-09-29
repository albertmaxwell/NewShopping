package com.shopping.shopping_protal_web.controller;

import com.alibaba.shopping.shopping_bean.bean.GoodsClass;
import com.shopping.shopping_protal_service.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 跳转阿里巴巴天猫商城主界面
 * @author 金海洋
 * @date 2019/9/29  -13:40
 */
@RequestMapping(value = "shoppingControllerIndex")
public class ShoppingControllerIndex {

	@Autowired
	IndexService indexService;

	/**
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "index")
	public String  index(Model model,String priceStart ,String priceEnd){

		Map<String,Object> map = new HashMap<String, Object>();
		try {
			List<GoodsClass> goodsClassList=indexService.getGoodsClassList(map);
			//添加商品分类数据
			model.addAttribute("goodsClass", goodsClassList);
		} catch (Exception e) {
			e.printStackTrace();
		}

         return "index";
	}








}
