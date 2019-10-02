package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.ArticleClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.ArticleClassDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:22
 */
@Repository("articleclassdao")
public class ArticleClassDaoImpl extends AbstractBaseDao<ArticleClass> implements ArticleClassDao {

	@Override
	public List<ArticleClass> findArticleClassList(Map<String,Object> map){

		Map params = new HashMap();
		params.put("mark", "news");
		List<ArticleClass> goodsClassList=this.findPage(0,10,"select obj from ArticleClass obj where obj.parent.id is null and obj.mark!=?1 order by obj.sequence asc", "news");
		return  goodsClassList;
	}


}