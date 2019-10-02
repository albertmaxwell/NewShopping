package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Goods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsClassDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:15
 */
@Repository("goodsdao")
public class GoodsDaoImpl extends AbstractBaseDao<Goods> implements GoodsDao {

	@Override
	public List<Goods> findGoodsList(Map<String,Object> map){
		Map params = new HashMap();
		params.put("store_recommend", Boolean.valueOf(true));
		params.put("goods_status", Integer.valueOf(0));
		List<Goods> goodsClassList=this.findPage(0,10,"select obj from Goods obj where obj.store_recommend=?1 and obj.goods_status=?2 order by obj.store_recommend_time desc", true,0);
		return  goodsClassList;
	}

}