package com.shopping.shopping_protal_service.service;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;

import java.util.List;

/**
 * @author 金海洋
 * @date 2019/10/1  -10:38
 */
public interface Jpaservice {

	public List<Test> getOrderByStoreId(String storeId);
}
