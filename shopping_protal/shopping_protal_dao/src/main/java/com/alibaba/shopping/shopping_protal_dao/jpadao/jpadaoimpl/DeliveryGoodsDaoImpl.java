package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.DeliveryGoods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.DeliveryGoodsDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsClassDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:13
 */
@Repository("deliverygoodsdao")
public class DeliveryGoodsDaoImpl extends AbstractBaseDao<DeliveryGoods> implements DeliveryGoodsDao {

	@Override
	public List<DeliveryGoods> findDeliveryGoodsList(Map<String,Object> map){
		List<DeliveryGoods> goodsClassList=this.find("a");
		return  goodsClassList;
	}
}
