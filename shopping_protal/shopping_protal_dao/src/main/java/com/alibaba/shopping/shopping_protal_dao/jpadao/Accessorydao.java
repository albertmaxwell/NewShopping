package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Accessory;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Album;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.ArticleClass;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/6  -15:51
 */
public interface Accessorydao  extends BaseDao<Accessory> {

	List<Accessory> findAccessoryList(Map<String,Object> s);

	void save(Accessory accessory);

	/**
	 *
	 * @param map
	 * @return
	 */
	List<Accessory> findPicList(Map<String,Object> map);

}
