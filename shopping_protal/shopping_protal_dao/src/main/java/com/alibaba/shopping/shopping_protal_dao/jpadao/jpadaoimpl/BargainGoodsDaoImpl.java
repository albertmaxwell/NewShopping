package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.BargainGoods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.DeliveryGoods;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.BargainGoodsDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.DeliveryGoodsDao;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:21
 */
@Repository("bargaingoodsdao")
public class BargainGoodsDaoImpl extends AbstractBaseDao<BargainGoods> implements BargainGoodsDao {


	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");


	@Override
	public List<BargainGoods> findBargainGoodsList(Map<String,Object> map){
		Map params = new HashMap();
		params.put("bg_time", formatDate(formatShortDate(new Date())));
		params.put("bg_status", Integer.valueOf(1));
		List<BargainGoods> goodsClassList=this.findPage(0,10,"select obj from BargainGoods obj where obj.bg_time=:bg_time and obj.bg_status=:bg_status", formatDate(formatShortDate(new Date())),Integer.valueOf(1));
		return  goodsClassList;
	}

	public static String formatShortDate(Object v){
		if (v == null) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(v);
	}

	public static Date formatDate(String s){
		Date d = null;
		try {
			d = dateFormat.parse(s);
		} catch (Exception localException){
		}
		return d;
	}
}
