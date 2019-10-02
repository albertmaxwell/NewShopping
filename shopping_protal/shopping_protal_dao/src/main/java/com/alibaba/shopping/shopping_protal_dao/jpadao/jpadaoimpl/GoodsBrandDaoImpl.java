package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsBrand;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsBrandDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsClassDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:14
 */
@Repository("goodsbranddao")
public class GoodsBrandDaoImpl extends AbstractBaseDao<GoodsBrand> implements GoodsBrandDao {

	@Override
	public List<GoodsBrand> findGoodsBrandList(Map<String,Object> map){
		Map params = new HashMap();
		// 推荐品牌
		params.put("audit", Integer.valueOf(1));
		params.put("recommend", Boolean.valueOf(true));
		List<GoodsBrand> goodsClassList=this.findPage(0,10,"select obj from GoodsBrand obj where obj.audit=?1 and obj.recommend=?2 order by obj.sequence", Integer.valueOf(1),Boolean.valueOf(true));
		return  goodsClassList;
	}


}
