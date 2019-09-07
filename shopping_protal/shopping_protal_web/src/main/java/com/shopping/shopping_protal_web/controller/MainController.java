package com.shopping.shopping_protal_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 金海洋
 * @date 2019/9/7  -10:09
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {

	/**
	 * 默认路由方法
	 *
	 * @return
	 */
	@RequestMapping(value = "/main")
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView("/main"); //设置对应JSP的模板文件

		return modelAndView;
	}


}
