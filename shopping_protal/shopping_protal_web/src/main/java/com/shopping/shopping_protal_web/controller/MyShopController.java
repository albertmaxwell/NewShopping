package com.shopping.shopping_protal_web.controller;

import com.alibaba.shopping.shopping_bean.bean.shopentity.domain.GoodsClass;
import com.shopping.shopping_protal_service.service.Jpaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/10/3  -9:24
 */
@Controller
@RequestMapping("/myShopController")
public class MyShopController {

	@Autowired
	Jpaservice sss;

	/**
	 * 商品发布  点击发布商品的时候
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addGoods",method = RequestMethod.GET)
	public String addGoods(Model model){

		Map<String,Object> map = new HashMap<String, Object>();
		List<GoodsClass> goodsClassList=sss.getGoodsClassList(map);
		model.addAttribute("goodsClassList",goodsClassList);
		return "web/GoodsFaBu";

	}


	@RequestMapping(value = "/goodsFabBuSecond",method = RequestMethod.GET)
	public String goodsFabBuSecond(HttpServletRequest request, HttpServletResponse response){



		return "web/GoodsFaBuSecond";
	}


	/**
	 * 销售中的商品
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "salingGoods")
	public String salingGoods(Model model){

		return "";

	}

	/**
	 * 仓库商品
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "caokuGoods")
	public String caokuGoods(Model model){

		return "";

	}

	/**
	 *
	 * 违规商品
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "weiguiGoods")
	public String weiguiGoods(Model model){

		return "";

	}

	/**
	 * 商品分类
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "goodsClass")
	public String goodsClass(Model model){

		return "";

	}

	/**
	 * 品牌申请
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "brandRequest")
	public String brandRequest(Model model){

		return "";

	}

	/**
	 * 被举报禁售
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "jubaoGoods")
	public String jubaoGoods(Model model){

		return "";

	}

	/**
	 * 闲置发布
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "xianzhiRes")
	public String xianzhiRes(Model model){

		return "";

	}

	/**
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "register")
	public String register(Model model){

		return "";

	}

	/**
	 * 淘宝导入
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "taobaoExp")
	public String taobaoExp(Model model){

		return "";

	}

	/**
	 * 订单管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "orderMangage")
	public String orderMangage(Model model){

		return "";

	}

	/**
	 * 支付方式
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "patStyle")
	public String patStyle(Model model){

		return "";

	}

	/**
	 * 物流工具
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "wuliuTools")
	public String wuliuTools(Model model){

		return "";

	}

	/**
	 * 我的店铺
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "myShop")
	public String myShop(Model model){

		return "";

	}

	/**
	 * 店铺设置
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "shopSet")
	public String shopSet(Model model){

		return "";

	}

	/**
	 * 子账户管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "sunAccountMsg")
	public String sunAccountMsg(Model model){

		return "";

	}

	/**
	 * 主题设置
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "themeSet")
	public String themeSet(Model model){

		return "";

	}

	/**
	 * 导航管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "daohangMsg")
	public String daohangMsg(Model model){

		return "";

	}

	/**
	 * 友情链接
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "friendLink")
	public String friendLink(Model model){

		return "";

	}

	/**
	 * 退款管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "quitMoney")
	public String quitMoney(Model model){

		return "";

	}

	/**
	 * 退货管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "quitGoods")
	public String quitGoods(Model model){

		return "";

	}

	/**
	 * 咨询管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "askMsg")
	public String askMsg(Model model){

		return "";

	}

	/**
	 * 投诉管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "fuckMsg")
	public String fuckMsg(Model model){

		return "";

	}

	/**
	 * 竞价直通车
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "jingjiaCar")
	public String jingjiaCar(Model model){

		return "";

	}

	/**
	 * 活动管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "activityMsg")
	public String activityMsg(Model model){

		return "";

	}

	/**
	 * 团购管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "teamMsg")
	public String teamMsg(Model model){

		return "";

	}

	/**
	 * 天天特价
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "dayGoodPrice")
	public String dayGoodPrice(Model model){

		return "";

	}

	/**
	 * 组合销售
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "togetherSale")
	public String togetherSale(Model model){

		return "";

	}

	/**
	 * 买就送
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "buyAndGive")
	public String buyAndGive(Model model){

		return "";

	}

	/**
	 * 金币管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "moneyMsg")
	public String moneyMsg(Model model){

		return "";

	}

	/**
	 * 广告管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "adMsg")
	public String adMsg(Model model){

		return "";

	}

	/**
	 * 图片管理
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "picMsg")
	public String picMsg(Model model){

		return "";

	}




}
