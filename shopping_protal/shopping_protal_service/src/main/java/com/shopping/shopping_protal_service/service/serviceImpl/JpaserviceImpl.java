package com.shopping.shopping_protal_service.service.serviceImpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;
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

	@Override
	public List<Test> getOrderByStoreId(String storeId){

		return orderdao.findOrderByStoreId("");

	}
}
