package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;

import java.util.List;

/**
 * @author 金海洋
 * @date 2019/10/1  -17:15
 */
public interface GoodsClassDao extends BaseDao<GoodsClass> {

	List<GoodsClass> findOrderByStoreId(long storeId);


	List<GoodsClass> findGoodsClass();

}
