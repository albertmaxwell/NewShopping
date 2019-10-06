package com.shopping.shopping_protal_service.service;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.*;
import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/1  -10:38
 */
public interface Jpaservice {

	List<GoodsClass> getGoodsClassList(Map<String, Object> map);

	List<GoodsBrand> getGoodsBrandList(Map<String, Object> map);

	List<Partner> getPartnerList(Map<String, Object> map);

	List<ArticleClass> getArticleClassList(Map<String, Object> map);

	List<Article> getArticleList(Map<String, Object> map);

	List<Goods> getGoodsList(Map<String, Object> map);

	List<GroupGoods> getGroupGoodsList(Map<String, Object> map);

	List<BargainGoods> getBargainGoodsList(Map<String, Object> map);

	List<DeliveryGoods> getDeliveryGoodsList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	GoodsClass getGoodsClassById(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<Album> getAlbumPage(Map<String, Object> map);

	List<Accessory> getAccessoryList(Map<String,Object> s);
}
