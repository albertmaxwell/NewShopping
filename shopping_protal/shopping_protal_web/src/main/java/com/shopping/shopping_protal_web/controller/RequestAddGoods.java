package com.shopping.shopping_protal_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 金海洋
 * @date 2019/10/3  -21:06
 */
@Controller
@RequestMapping("/requestGoods")
public class RequestAddGoods {

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



	}
}
