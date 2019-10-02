package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Goods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsBrand;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -9:48
 */
public interface GoodsDao  extends BaseDao<Goods> {

	List<Goods> findGoodsList(Map<String,Object> map);

}
