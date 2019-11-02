package com.alibaba.shopping.shopping_protal_dao.jpadao.jpadaoimpl;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Accessory;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Album;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AbstractBaseDao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.Accessorydao;
import com.alibaba.shopping.shopping_protal_dao.jpadao.AlbumDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Access;
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
	public List<Accessory> findPicList(Map<String,Object> map){

		//int counts=this.count("select obj from Accessory obj  where ext='fff' ",null);
		//Double pageNums=Math.ceil(counts/(Double.parseDouble(map.get("pageSize").toString())));
		//Integer a=Integer.parseInt(map.get("currData").toString());
		//Integer b=Integer.parseInt(map.get("overData").toString());
		List<Accessory> goodsClassList=this.findPage(0,20,"select obj from Accessory obj  where ext='fff'  ");
		return  goodsClassList;
	}


}

