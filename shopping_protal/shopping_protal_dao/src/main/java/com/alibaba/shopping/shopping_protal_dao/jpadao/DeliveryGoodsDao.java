package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.DeliveryGoods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Goods;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -9:52
 */
public interface DeliveryGoodsDao extends BaseDao<DeliveryGoods> {

	List<DeliveryGoods> findDeliveryGoodsList(Map<String,Object> map);

}
