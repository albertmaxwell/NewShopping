package com.alibaba.shopping.shoppingcommonutils.common.controller;

import com.alibaba.shopping.shoppingcommonutils.common.bean.area;
import com.alibaba.shopping.shoppingcommonutils.common.cache.AreaCache;
import com.alibaba.shopping.shoppingcommonutils.common.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/8/27  -9:36
 */
@Controller
@RequestMapping("/areaController")
public class AreaController {

	@Autowired
	AreaService area;

    @RequestMapping(value = "/getArea",method = RequestMethod.GET)
	public String getArea(ModelMap modelMap) {
		AreaCache apc = AreaCache.getInstance();
		System.out.println(apc.getCityCache());
		System.out.println(apc.getProvinceCache());
		System.out.println(apc.getAreaCache());
		modelMap.addAttribute("province", area.getProvinceList());
		modelMap.addAttribute("city", area.getCityList());
		modelMap.addAttribute("district", area.getDistrictList());
		return "area";

}
   @ResponseBody
   @RequestMapping(value = "/getAreaById",method = RequestMethod.GET)
	public List<Map<String, area>> getAreaById(String areaPid) {
	   List<Map<String, area>> result=null;
	   result=area.findAreaById(areaPid);
	   return result;

}



}
