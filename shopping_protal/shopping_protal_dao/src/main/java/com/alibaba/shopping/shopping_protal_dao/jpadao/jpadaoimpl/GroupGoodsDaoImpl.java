package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Goods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GroupGoods;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GroupGoodsDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:18
 */
@Repository("groupgoodsdao")
public class GroupGoodsDaoImpl  extends AbstractBaseDao<GroupGoods> implements GroupGoodsDao {

	@Override
	public List<GroupGoods> findGroupGoodsList(Map<String,Object> map){
		Map params = new HashMap();
		params.put("gg_status", Integer.valueOf(1));
		params.put("gg_recommend", Integer.valueOf(1));
		List<GroupGoods> goodsClassList=this.findPage(0,10,"select obj from GroupGoods obj where obj.gg_status=?1 and obj.gg_recommend=?2 and obj.group.id=:group_id order by obj.gg_recommend_time desc", Integer.valueOf(1),Integer.valueOf(1));
		return  goodsClassList;
	}

}