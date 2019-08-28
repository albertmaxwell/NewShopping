package com.alibaba.shopping.shoppingcommonutils.common.controller;

import com.alibaba.shopping.shoppingcommonutils.common.bean.DeptEmtity;
import com.alibaba.shopping.shoppingcommonutils.common.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 树
 * @author 金海洋
 * @date 2019/8/28  -13:47
 */
@Controller
@RequestMapping("/treeController")
public class TreeController {

	@Autowired
	TreeService treeService;

    @ResponseBody
	@RequestMapping(value = "/getNodeTree",method = RequestMethod.GET)
	public List<DeptEmtity> getNodeTree() {

		List<DeptEmtity> deptEmtityList=treeService.getNoteTree();
		return deptEmtityList;
	}




}
