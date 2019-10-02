package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.BargainGoods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsBrand;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -9:50
 */
public interface BargainGoodsDao extends BaseDao<BargainGoods> {

	List<BargainGoods> findBargainGoodsList(Map<String,Object> map);

}
