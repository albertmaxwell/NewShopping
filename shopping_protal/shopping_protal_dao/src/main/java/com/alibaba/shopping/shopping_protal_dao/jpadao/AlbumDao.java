package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Album;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Article;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/6  -10:55
 */
public interface AlbumDao extends BaseDao<Album> {

	/**
	 *
	 * @param map
	 * @return
	 */
	List<Album> findAlbumPage(Map<String,Object> map);

}
