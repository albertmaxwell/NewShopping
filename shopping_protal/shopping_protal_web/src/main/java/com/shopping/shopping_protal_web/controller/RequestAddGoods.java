package com.shopping.shopping_protal_web.controller;

import com.alibaba.shopping.common.response.ResponseMessage;
import com.alibaba.shopping.common.response.Result;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.Goods;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsBrand;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.shopping.shopping_protal_service.service.Jpaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author 金海洋
 * @date 2019/10/3  -21:06
 */
@Controller
@RequestMapping("/requestGoods")
public class RequestAddGoods {

	@Autowired
	Jpaservice sss;

	/**
	 * 处理逻辑
	 *
	 * 1、首先判断是否含有当前用户的session  如果没有就返回一个禁止提交的页面处理
	 * 2、然后判断当前用户的session如果等于前端传过的session。
	 * 3、如果等于的话判断相关参数是否为空
	 * 4、然后【判断当前商品的id是否为，如果为空的话就是新增页面
	 * 5、如果不是空的那么就新增页面成功。
	 * 6、给相关的商品字段设置数据
	 * 7、图片上传是异步的，当前端把图片上成功的时候就会返回一个图片id，提交表单的时候把这个id传过来然后
	 * 利用id查询图片的url设置到商品的图片字段中
	 * 8、下面判断一些如品牌非校验必填的参数如果有的话那么就设置到商品goods中
	 * 9、
	 * @param request
	 * @param response
	 * @param goodsBrandType
	 * @param goodsName
	 * @param goodsYuanPrice
	 * @param goodsType
	 * @param goodsPrice
	 * @param goodsConfig
	 * @param goodsKuCun
	 * @param goodsHuoHao
	 * @param goodsWeight
	 * @param goodsSpace
	 * @param yunfeiWho
	 * @param newGoodsClass
	 * @param rememed
	 * @param seoKeyWord
	 * @param seoDes
	 */
	@RequestMapping(value = "/addGoods" ,method = RequestMethod.POST)
	@ResponseBody()
	public void addRequestGoods(HttpServletRequest request, HttpServletResponse response,
								String goodsBrandType,
								String goodsName,
								String goodsYuanPrice,
								String goodsType,
								String goodsPrice,
								String goodsConfig,
								String goodsKuCun,
								String goodsHuoHao,
								String goodsWeight,
								String goodsSpace,
								String yunfeiWho,
								String newGoodsClass,
								String rememed,
								String seoKeyWord,
								String seoDes
								 ){
		Goods goods = null;
		goods.setAddTime(new Date());
//		User user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
//		goods.setGoods_store("");
		goods.setGoods_current_price(goods.getStore_price());
		goods.setGoods_name(goods.getGoods_name());
//		GoodsClass gc = this.goodsClassService.getObjById(Long.valueOf(Long.parseLong(goods_class_id)));
//		goods.setGc(gc);

//		if ((goods_main_img_id != null) && (!goods_main_img_id.equals(""))){
//			main_img = this.accessoryService.getObjById(Long.valueOf(Long.parseLong(goods_main_img_id)));
//		}
//		goods.setGoods_main_photo(main_img);

//		if ((goods_brand_id != null) && (!goods_brand_id.equals(""))){
//			GoodsBrand goods_brand = this.goodsBrandService.getObjById(Long.valueOf(Long.parseLong(goods_brand_id)));
//			goods.setGoods_brand(goods_brand);
//		}

		// 组装商品属性
//		goods.setGoods_property(Json.toJson(maps, JsonFormat.compact()));

		// 组装商品多规格库存和价格
//		goods.setGoods_inventory_detail(Json.toJson(maps, JsonFormat.compact()));

		goods.setTransport(null);
//		this.goodsService.save(goods);



	}


	/**
	 *
	 * 根据pid选择对应的下级分类
	 * @param request
	 * @param response
	 * @param pid
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/loadGoodsclass" ,method = RequestMethod.GET)
	public ResponseMessage<?> loadGoodsclass(HttpServletRequest request,
										  HttpServletResponse response, String pid, String session){

		Map<String,Object> pidmap = new HashMap<String, Object>();
		pidmap.put("pid",pid);
		GoodsClass obj=sss.getGoodsClassById(pidmap);
		List list = new ArrayList();
		if (obj != null){
			for (GoodsClass gc : obj.getChilds()){
				Map map = new HashMap();
				map.put("id", gc.getId());
				map.put("className", gc.getClassName());
				list.add(map);
			}
		}
		return Result.success(list);
	}



}
