package com.alibaba.shopping.shoppingcommonutils.common.service;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/8/27  -9:43
 */
public interface AreaService {


	List<Map<String, Object>>  getProvinceList();

	List<Map<String, Object>>  getCityList();

	List<Map<String, Object>>  getDistrictList();

	List<Map<String, Object>> findAreaById(String areaPid);
}
