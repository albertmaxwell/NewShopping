package com.shopping.shopping_protal_service.service;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:35
 */
public interface IndexService  extends CommonService {

	/**
	 * 获取首页商品分类
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<GoodsClass> getGoodsClassList(Map<String, Object> map) throws Exception;

	/**
	 * 获取首页产品品牌
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<GoodsBrand> getGoodsBrandList(Map<String, Object> map) throws Exception;

	/**
	 *
	 * 获取合作伙伴
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Partner> getPartnerList(Map<String, Object> map) throws Exception;

	/**
	 *
	 * 获取文章分类
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<ArticleClass> getArticleClassList(Map<String, Object> map) throws Exception;

	/**
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Article> getArticleList(Map<String, Object> map) throws Exception;

	/**
	 *
	 * 获取商品列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Goods> getGoodsList(Map<String, Object> map) throws Exception;

	/**
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<GroupGoods> getGroupGoodsList(Map<String, Object> map) throws Exception;

	/**
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<BargainGoods> getBargainGoodsList(Map<String, Object> map) throws Exception;

	/**
	 *
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DeliveryGoods> getDeliveryGoodsList(Map<String, Object> map) throws Exception;


	/**
	 * 保存实体
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Serializable save(GoodsClass entity) throws Exception;


}
