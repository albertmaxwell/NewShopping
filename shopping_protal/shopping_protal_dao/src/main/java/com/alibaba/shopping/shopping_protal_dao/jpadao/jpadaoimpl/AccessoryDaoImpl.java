package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.common.vo.PictureVo;
import com.alibaba.shopping.common.vo.ResultVoFactory.DataGrid;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Accessory;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Album;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.Accessorydao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AlbumDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.Access;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/6  -15:54
 */
@Repository("accessorydao")
public class AccessoryDaoImpl extends AbstractBaseDao<Accessory> implements Accessorydao {

	@Override
	public List<Accessory> findAccessoryList(Map<String,Object> s){

		List<Accessory> goodsClassList=this.find("select obj from Accessory obj where obj.album.id=?1",Long.parseLong(s.get("albumId").toString()));
		return  goodsClassList;
	}

	@Override
	public void save(Accessory accessory){

		this.add(accessory);
	}

	@Override
	public DataGrid findPicList(Map<String,Object> map){
		DataGrid dataGrid=new DataGrid();
		int counts=this.count("select obj from Accessory obj  where ext='fff' ");
		//Double pageNums=Math.ceil(counts/(Double.parseDouble(map.get("pageSize").toString())));
		Integer a=Integer.parseInt(map.get("currData").toString());
		Integer b=Integer.parseInt(map.get("overData").toString());
		List<Accessory> goodsClassList=this.findPage(a,b,"select obj from Accessory obj  where ext='fff'  ");
		dataGrid.setResults(goodsClassList);
		dataGrid.setTotal(counts);
		return  dataGrid;
	}

	/**
	 * 动态分页
	 *
	 * @param page
	 * @param size
	 * @return
	 */
	/*public Page<Book> findPictureCriteria(Integer page, Integer size, PictureVo pictureVo) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "createDate");
		Page<Book> bookPage = systemUserRepository.findAll(new Specification<Book>() {
			@Override
			public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(null!=systemUserQueryVo.getUserCode()&&!"".equals(pictureVo.getUrl())){
					list.add(criteriaBuilder.equal(root.get("userCode").as(String.class), systemUserQueryVo.getUserCode()));
				}
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		}, pageable);
		return bookPage;
	}*/


}

