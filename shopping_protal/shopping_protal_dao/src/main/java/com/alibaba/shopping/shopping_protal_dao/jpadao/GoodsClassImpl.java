package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/1  -17:19
 */
@Repository("goodsclass")
public class GoodsClassImpl extends AbstractBaseDao<GoodsClass> implements GoodsClassDao {


	@Override
	public List<GoodsClass> findOrderByStoreId(long level){
		List<GoodsClass> orders = this.find("SELECT o FROM GoodsClass o WHERE o.id = ?1 ", level);
		return orders;
	}
	@Override
	public List<GoodsClass> findGoodsClass(){
		Map params = new HashMap();
		List<GoodsClass> orders = this.find("select obj from GoodsClass obj where obj.parent.id is null and obj.display=:display order by obj.sequence asc", params, 0, 15);
		return orders;
	}




}
