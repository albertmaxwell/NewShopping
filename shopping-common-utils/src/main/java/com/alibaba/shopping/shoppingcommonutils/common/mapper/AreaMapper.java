package com.alibaba.shopping.shoppingcommonutils.common.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/8/27  -9:46
 */
public interface AreaMapper {

	List<Map<String, Object>>  selectAllProvince();

	List<Map<String, Object>>  selectAllCity();

	List<Map<String, Object>>  selectAllDistrict();

	List<Map<String, Object>> selectAreaById(String areaPid);
}
