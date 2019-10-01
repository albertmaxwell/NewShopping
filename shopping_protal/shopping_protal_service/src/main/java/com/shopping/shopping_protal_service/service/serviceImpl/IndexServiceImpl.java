package com.shopping.shopping_protal_service.service.serviceImpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.*;
import com.shopping.shopping_protal_service.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:36
 */
@Service("indexService")
@Transactional
public class IndexServiceImpl  implements IndexService {

	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public List<GoodsClass> getGoodsClassList(Map<String, Object> map) throws Exception {

//		List<Map<String, Object>> mapList=jdbcTemplate.queryForList("select * from user");

		return null;
	}

	@Override
	public List<GoodsBrand> getGoodsBrandList(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public List<Partner> getPartnerList(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public List<ArticleClass> getArticleClassList(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public List<Article> getArticleList(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public List<Goods> getGoodsList(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public List<GroupGoods> getGroupGoodsList(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public List<BargainGoods> getBargainGoodsList(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public List<DeliveryGoods> getDeliveryGoodsList(Map<String, Object> map) throws Exception {
		return null;
	}


}
