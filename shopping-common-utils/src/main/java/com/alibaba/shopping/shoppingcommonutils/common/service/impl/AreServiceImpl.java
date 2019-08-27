package com.alibaba.shopping.shoppingcommonutils.common.service.impl;

import com.alibaba.shopping.shoppingcommonutils.common.mapper.AreaMapper;
import com.alibaba.shopping.shoppingcommonutils.common.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.geom.Area;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/8/27  -9:43
 */
@Service("area")
@Transactional
public class AreServiceImpl implements AreaService {

	@Autowired
	AreaMapper areaMapper;

	@Override
	public List<Map<String, Object>>  getProvinceList() {
		List<Map<String, Object>>  provinces=areaMapper.selectAllProvince();
		return provinces;
	}

	@Override
	public List<Map<String, Object>>  getCityList() {
		List<Map<String, Object>>  citys =areaMapper.selectAllCity();
		return citys;
	}

	@Override
	public List<Map<String, Object>>  getDistrictList() {
		List<Map<String, Object>>   districts=areaMapper.selectAllDistrict();
		return districts;
	}

	@Override
	public List<Map<String, Object>> findAreaById(String areaPid) {
		List<Map<String, Object>>  ares=areaMapper.selectAreaById(areaPid);
		return ares;
	}
}
