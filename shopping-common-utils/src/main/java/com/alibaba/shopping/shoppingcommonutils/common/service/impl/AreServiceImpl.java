package com.alibaba.shopping.shoppingcommonutils.common.service.impl;

import com.alibaba.shopping.shoppingcommonutils.common.bean.area;
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
	public List<Map<String, area>>  getProvinceList() {
		List<Map<String, area>>  provinces=areaMapper.selectAllProvince();
		return provinces;
	}

	@Override
	public List<Map<String, area>>  getCityList() {
		List<Map<String, area>>  citys =areaMapper.selectAllCity();
		return citys;
	}

	@Override
	public List<Map<String, area>>  getDistrictList() {
		List<Map<String, area>>   districts=areaMapper.selectAllDistrict();
		return districts;
	}

	@Override
	public List<Map<String, area>> findAreaById(String areaPid) {
		List<Map<String, area>>  ares=areaMapper.selectAreaById(areaPid);
		return ares;
	}
}
