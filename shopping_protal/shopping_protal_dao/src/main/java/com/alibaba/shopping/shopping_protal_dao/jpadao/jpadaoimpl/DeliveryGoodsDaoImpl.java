package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.DeliveryGoods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.DeliveryGoodsDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsClassDao;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
		List<DeliveryGoods> goodsClassList=this.findPage(0,5,"select obj from DeliveryGoods obj where obj.d_status=?1 and obj.d_begin_time<=?2 and obj.d_end_time>=?3 order by obj.d_audit_time desc",Integer.valueOf(1),new Date(),new Date());
		return  goodsClassList;
	}
}
