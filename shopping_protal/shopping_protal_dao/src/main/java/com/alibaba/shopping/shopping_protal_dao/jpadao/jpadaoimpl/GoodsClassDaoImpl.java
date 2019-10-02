package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsClassDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/1  -17:19
 */
@Repository("goodsclass")
public class GoodsClassDaoImpl extends AbstractBaseDao<GoodsClass> implements GoodsClassDao {

	@Override
	public List<GoodsClass> findGoodsClassList(Map<String,Object> map){
		List<GoodsClass> goodsClassList=this.findPage(0,10,"select obj from GoodsClass obj where obj.parent.id is null and obj.display=?1 order by obj.sequence asc",Boolean.valueOf(true));
		return  goodsClassList;
	}


}
