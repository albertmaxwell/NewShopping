package com.alibaba.shopping.shoppingcommonutils.common.service.impl;

import com.alibaba.shopping.shoppingcommonutils.common.service.CacheServiceI;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Service;

/**
 * @author 金海洋
 * @date 2019/8/30  -17:59
 */
@Service("cacheService")
public class EhcacheService  implements CacheServiceI {

	public static CacheManager manager = CacheManager.create();


	@Override
	public Object get(String cacheName, Object key) {

		Cache cache = manager.getCache(cacheName);
		if (cache != null) {
			Element element = cache.get(key);
			if (element != null) {
				return element.getObjectValue();
			}
		}
		return null;
	}

	@Override
	public void put(String cacheName, Object key, Object value) {

		Cache cache = manager.getCache(cacheName);
		if (cache != null) {
			cache.put(new Element(key, value));
		}
	}


}
