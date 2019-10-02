package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsBrand;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GroupGoods;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -9:49
 */
public interface GroupGoodsDao extends BaseDao<GroupGoods> {

	List<GroupGoods> findGroupGoodsList(Map<String,Object> map);

}
