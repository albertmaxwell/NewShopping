package com.shopping.shopping_protal_web.controller;

import com.alibaba.shopping.common.response.ResponseMessage;
import com.alibaba.shopping.common.response.Result;
import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.*;
import com.alibaba.shopping.shopping_bean.bean.shopentity.test.Test;
import com.shopping.shopping_protal_service.service.IndexService;
import com.shopping.shopping_protal_service.service.Jpaservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 跳转阿里巴巴天猫商城主界面
 * @author 金海洋
 * @date 2019/9/29  -13:40
 */
@Api(tags = "天猫首页接口")
@Controller
@RequestMapping(value = "shoppingControllerIndex")
public class ShoppingControllerIndex {

	@Autowired
	IndexService indexService;

	@Autowired
	Jpaservice sss;


	/**
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "index",method = RequestMethod.GET)
	@ApiOperation(value = "天猫首页获取数据接口", notes = "传入对象数据", produces = "application/json")
	public String  index(Model model){

		Map<String,Object> map = new HashMap<String, Object>();
		try {
			List<GoodsClass> goodsClassList=indexService.getGoodsClassList(map);
			/*List<GoodsBrand> goodsBrandList=indexService.getGoodsBrandList(map);
			List<Partner>  partnerList=indexService.getPartnerList(map);
			List<ArticleClass>  articleClassList=indexService.getArticleClassList(map);
			List<Article>  articleList=indexService.getArticleList(map);
			List<Goods>  goodsList=indexService.getGoodsList(map);
			List<GroupGoods>  groupGoodsList=indexService.getGroupGoodsList(map);
			List<BargainGoods>  bargainGoodsList=indexService.getBargainGoodsList(map);
			List<DeliveryGoods>  deliveryGoodsList=indexService.getDeliveryGoodsList(map);*/
			//添加商品分类数据
			model.addAttribute("goodsClassList", goodsClassList);
			/*//添加品牌数据
			model.addAttribute("goodsBrandList", goodsBrandList);
			//底部显示的合作伙伴
			model.addAttribute("partnerList", partnerList);
			//底部新闻分类显示
			model.addAttribute("articleClassList", articleClassList);
			//商城新闻
			model.addAttribute("articleList", articleList);
			//查询推荐店铺商品
			model.addAttribute("goodsList", goodsList);
			//团购商品
			model.addAttribute("groupGoodsList", groupGoodsList);
			//天天特价
			model.addAttribute("bargainGoodsList", bargainGoodsList);
			//满送商品
			model.addAttribute("deliveryGoodsList", deliveryGoodsList);*/
		} catch (Exception e) {
			e.printStackTrace();
		}

         return "hello";
	}


	/**
	 *
	 * @return
	 */
	@RequestMapping(value = "/hibernateGoodClass", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "hibernate商品新增接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> hibernateGoodClass() {
		try {
			GoodsClass goodsClass=new GoodsClass();
			//goodsClass.setClassName("电子产品");
			//indexService.save(goodsClass);
		}  catch (Exception e) {
			e.printStackTrace();
			return Result.success("添加失败");
		}
		return Result.success("添加成功");
	}

	/**
	 *
	 * @return
	 */
	@RequestMapping(value = "/jpaGoodClass", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "JPA商品新增接口", notes = "传入对象数据", produces = "application/json")
	public ResponseMessage<?> jpaGoodClass() {
		List<Test> testList=null;
		try {
			GoodsClass goodsClass=new GoodsClass();
			//goodsClass.setClassName("电子产品");
			testList=sss.getOrderByStoreId("tfdsfg");
		}  catch (Exception e) {
			e.printStackTrace();
			return Result.success("添加失败");
		}
		return Result.success(testList);
	}


}
