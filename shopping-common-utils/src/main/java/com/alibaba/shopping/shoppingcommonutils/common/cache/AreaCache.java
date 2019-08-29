package com.alibaba.shopping.shoppingcommonutils.common.cache;

import com.alibaba.shopping.shoppingcommonutils.common.bean.area;

import java.util.List;
import java.util.Map;

/**
 * 就是java的静态成员变量是有一个独立的存储空间的。
 * 假设一个类里面如果有一个静态变量s，那个这个类的多个实例所引用的s实际上是同一个
 * @author 金海洋
 * @date 2019/8/29  -11:42
 */
public class AreaCache {

	public static AreaCache instance;

	public static AreaCache getInstance() {
		if (instance == null) {
			instance = new AreaCache();
		}
		return instance;
	}

	public static void setInstance(AreaCache instance) {
		AreaCache.instance = instance;
	}

	public List<Map<String, area>> provinceCache;
	public List<Map<String, area>> cityCache;
	public List<Map<String, area>> areaCache;

	public List<Map<String, area>> getProvinceCache() {
		return provinceCache;
	}

	public void setProvinceCache(List<Map<String, area>> provinceCache) {
		this.provinceCache = provinceCache;
	}

	public List<Map<String, area>> getCityCache() {
		return cityCache;
	}

	public void setCityCache(List<Map<String, area>> cityCache) {
		this.cityCache = cityCache;
	}

	public List<Map<String, area>> getAreaCache() {
		return areaCache;
	}

	public void setAreaCache(List<Map<String, area>> areaCache) {
		this.areaCache = areaCache;
	}



}
