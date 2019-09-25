package com.alibaba.shopping.shoppingcommonutils.common.service;

import org.springframework.stereotype.Service;

/**
 * @author 金海洋
 * @date 2019/8/30  -17:53
 */
public interface CacheServiceI {

	/**
	 * 类注解&系统缓存[临时缓存]
	 */
	public static String SYSTEM_BASE_CACHE = "systemBaseCache";

	/**
	 * 字典\国际化\在线用户列表 [永久缓存]
	 */
	public static String FOREVER_CACHE = "foreverCache";

	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public Object get(String cacheName, Object key);

	/**
	 * 设置缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public void put(String cacheName, Object key, Object value);



}
