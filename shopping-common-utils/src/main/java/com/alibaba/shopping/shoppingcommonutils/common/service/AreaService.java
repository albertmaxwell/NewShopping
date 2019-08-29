package com.alibaba.shopping.shoppingcommonutils.common.service;

import com.alibaba.shopping.shoppingcommonutils.common.bean.area;


import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/8/27  -9:43
 */
public interface AreaService {


	List<Map<String, area>>  getProvinceList();

	List<Map<String, area>>  getCityList();

	List<Map<String, area>>  getDistrictList();

	List<Map<String, area>> findAreaById(String areaPid);
}
