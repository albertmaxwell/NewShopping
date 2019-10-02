package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Article;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.ArticleClass;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.ArticleClassDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.ArticleDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.GoodsClassDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/2  -10:19
 */
@Repository("articledao")
public class ArticleDaoImpl extends AbstractBaseDao<Article> implements ArticleDao {

	@Override

	public List<Article> findArticleList(Map<String,Object> map){

		Map params = new HashMap();
		params.put("class_mark", "news");
		params.put("display", Boolean.valueOf(true));
		List<Article> goodsClassList=this.findPage(0,5,"select obj from Article obj where obj.articleClass.mark=?1 and obj.display=?2 order by obj.addTime desc", "news",Boolean.valueOf(true));
		return  goodsClassList;
	}


}
