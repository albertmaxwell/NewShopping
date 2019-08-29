package com.alibaba.shopping.shoppingcommonutils.common.mapper;

import com.alibaba.shopping.shoppingcommonutils.common.bean.area;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/8/27  -9:46
 */
public interface AreaMapper {

	List<Map<String, area>>  selectAllProvince();

	List<Map<String, area>>  selectAllCity();

	List<Map<String, area>>  selectAllDistrict();

	List<Map<String, area>> selectAreaById(String areaPid);
}
