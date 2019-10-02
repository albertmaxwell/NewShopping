package com.shopping.shopping_protal_service.service.serviceImpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.*;
import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;
import com.alibaba.shopping.shopping_protal_dao.jpadao.*;
import com.shopping.shopping_protal_service.service.Jpaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/1  -10:38
 */
@Service("sss")
@Transactional
public class JpaserviceImpl implements Jpaservice {

	@Autowired
	private GoodsClassDao goodsclass;
	@Autowired
	private GoodsBrandDao goodsbranddao;
	@Autowired
	private PartnerDao parentdao;
	@Autowired
	private ArticleClassDao articleclassdao;
	@Autowired
	private ArticleDao articledao;
	@Autowired
	private GoodsDao goodsdao;
	@Autowired
	private GroupGoodsDao groupgoodsdao;
	@Autowired
	private BargainGoodsDao bargaingoodsdao;
	@Autowired
	private DeliveryGoodsDao deliverygoodsdao;



	@Override
	public List<GoodsClass> getGoodsClassList(Map<String, Object> map) {

		List<GoodsClass> goodsClasses=goodsclass.findGoodsClassList(map);
		return goodsClasses;
	}

	@Override
	public List<GoodsBrand> getGoodsBrandList(Map<String, Object> map) {

		List<GoodsBrand> goodsBrands=goodsbranddao.findGoodsBrandList(map);
		return goodsBrands;
	}

	@Override
	public List<Partner> getPartnerList(Map<String, Object> map) {

		List<Partner> partners=parentdao.findPartnerList(map);
		return partners;
	}

	@Override
	public List<ArticleClass> getArticleClassList(Map<String, Object> map) {

		List<ArticleClass> articleClasses=articleclassdao.findArticleClassList(map);
		return articleClasses;
	}

	@Override
	public List<Article> getArticleList(Map<String, Object> map) {

		List<Article> articles= articledao.findArticleList(map);
		return articles;
	}

	@Override
	public List<Goods> getGoodsList(Map<String, Object> map) {

		List<Goods> goods= goodsdao.findGoodsList(map);
		return goods;
	}

	@Override
	public List<GroupGoods> getGroupGoodsList(Map<String, Object> map) {

		List<GroupGoods>  groupGoods=groupgoodsdao.findGroupGoodsList(map);
		return groupGoods;
	}

	@Override
	public List<BargainGoods> getBargainGoodsList(Map<String, Object> map) {

		List<BargainGoods> bargainGoods=bargaingoodsdao.findBargainGoodsList(map);
		return bargainGoods;
	}

	@Override
	public List<DeliveryGoods> getDeliveryGoodsList(Map<String, Object> map) {

		List<DeliveryGoods> deliveryGoods=deliverygoodsdao.findDeliveryGoodsList(map);
		return deliveryGoods;
	}
}
