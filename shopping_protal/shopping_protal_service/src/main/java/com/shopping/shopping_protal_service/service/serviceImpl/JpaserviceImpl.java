package com.shopping.shopping_protal_service.service.serviceImpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsClassDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.OrderDao;
import com.shopping.shopping_protal_service.service.Jpaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 金海洋
 * @date 2019/10/1  -10:38
 */
@Service("sss")
@Transactional
public class JpaserviceImpl implements Jpaservice {

	@Autowired
	private OrderDao orderdao;
	@Autowired
	private GoodsClassDao goodsclass;

	@Override
	public List<Test> getOrderByStoreId(String storeId){

		return orderdao.findOrderByStoreId("");
	}

	@Override
	public List<GoodsClass> getGoodsClassById(long storeId) {

		List<GoodsClass> goodsClasses=goodsclass.findOrderByStoreId(storeId);
		return goodsClasses;
	}

	@Override
	public List<GoodsClass> getGoodsClass() {

		List<GoodsClass> goodsClasses=goodsclass.findGoodsClass();
		return goodsClasses;
	}
}
