package com.shopping.shopping_protal_service.service;

import com.alibaba.shopping.shopping_bean.bean.GoodsBrand;
import com.alibaba.shopping.shopping_bean.bean.GoodsClass;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:35
 */
public interface IndexService {

	/**
	 * 获取商品分类列表
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<GoodsClass> getGoodsClassList(Map<String, Object> map) throws Exception;

	public List<GoodsBrand> getGoodsBrandList(Map<String, Object> map) throws Exception;

}
