package com.shopping.shopping_protal_web.controller;


import com.alibaba.shopping.shopping_bean.bean.UserMembers;
import com.shopping.shopping_protal_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/8/17  -13:21
 */
@Controller
@RequestMapping("/userController")
public class HelloController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getAllUser")
	@ResponseBody
	public List<UserMembers> getAllUser(){

		List<UserMembers> userMembers= userService.getAllUser();

		return userMembers;
	}



}
