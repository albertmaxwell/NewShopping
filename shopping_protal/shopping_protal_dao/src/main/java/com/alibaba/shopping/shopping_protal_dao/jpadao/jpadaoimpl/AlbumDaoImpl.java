package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Album;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Article;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.ArticleClass;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:19
 */
@Repository("albumdao")
public class AlbumDaoImpl extends AbstractBaseDao<Album> implements AlbumDao {

	@Override
	public List<Album> findAlbumPage(Map<String,Object> map){

		Map params = new HashMap();
		params.put("class_mark", "news");
		params.put("display", Boolean.valueOf(true));
		List<Album> goodsClassList=this.findPage(0,5,"select obj from Album obj ");
		return  goodsClassList;
	}


}
