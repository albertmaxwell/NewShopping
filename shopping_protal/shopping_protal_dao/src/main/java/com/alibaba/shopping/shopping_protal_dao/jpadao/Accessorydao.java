package com.alibaba.shopping.shopping_protal_dao.jpadao;

import com.alibaba.shopping.common.vo.PictureVo;
import com.alibaba.shopping.common.vo.ResultVoFactory.DataGrid;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Accessory;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Album;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.ArticleClass;
import org.springframework.data.domain.Page;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/6  -15:51
 */
public interface Accessorydao  extends BaseDao<Accessory> {

	/**
	 *
	 * @param s
	 * @return
	 */
	List<Accessory> findAccessoryList(Map<String,Object> s);

	/**
	 *
	 * @param accessory
	 */
	void save(Accessory accessory);

	/**
	 *
	 * @param map
	 * @return
	 */
	DataGrid findPicList(Map<String,Object> map);

	/**
	 *
	 * 动态分页
	 * @param page
	 * @param size
	 * @return
	 */
/*
	Page<Book> findPictureCriteria(Integer page, Integer size, PictureVo pictureVo);
*/

}
