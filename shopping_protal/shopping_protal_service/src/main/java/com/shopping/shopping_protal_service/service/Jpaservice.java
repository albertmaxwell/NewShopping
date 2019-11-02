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

	/**
	 *
	 * @param map
	 * @return
	 */
	List<GoodsClass> getGoodsClassList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<GoodsBrand> getGoodsBrandList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<Partner> getPartnerList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<ArticleClass> getArticleClassList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<Article> getArticleList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<Goods> getGoodsList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<GroupGoods> getGroupGoodsList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<BargainGoods> getBargainGoodsList(Map<String, Object> map);

	/**
	 *
	 * @param map
	 * @return
	 */
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

	/**
	 *
	 * @param map
	 * @return
	 */
	List<Album> findAlbumBySomeThing(String sql,Object... obj);

	List<Accessory> getAccessoryList(Map<String,Object> s);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<Album> getAlbumDic(Map<String, Object> map);

	/**
	 *
	 * @param accessory
	 */
	public void save(Accessory accessory);

	/**
	 *
	 * @param accessory
	 */
	public void saveAlbum(Album album);
}
