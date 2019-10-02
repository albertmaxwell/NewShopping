package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Goods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Partner;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.PartnerDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:16
 */
@Repository("parentdao")
public class PartnerDaoImpl extends AbstractBaseDao<Partner> implements PartnerDao {

	@Override
	public List<Partner> findPartnerList(Map<String,Object> map){
		Map params = new HashMap();
		List<Partner> goodsClassList=this.find("select obj from Partner obj where obj.image.id is not null order by obj.sequence asc", params, -1, -1);
		return  goodsClassList;
	}

}
