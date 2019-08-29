package com.alibaba.shopping.shoppingcommonutils.common.listenter;

import com.alibaba.shopping.shoppingcommonutils.common.cache.AreaCache;
import com.alibaba.shopping.shoppingcommonutils.common.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 在项目启动过程中做一些事情
 * @author 金海洋  监听启动类
 * @date 2019/8/29  -11:32
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)//监听器  监听启动类
public class ApplyUpLoadListener  implements ApplicationListener<ContextRefreshedEvent>, ApplicationRunner {

	@Autowired
	AreaMapper areaMapper;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		upLoadArea();
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("加载数据中..........");
	}

	/**
	 * 从缓存中加载数据
	 */
	private void upLoadArea() {
		AreaCache ast = AreaCache.getInstance();
		ast.setProvinceCache(areaMapper.selectAllProvince());
		ast.setCityCache(areaMapper.selectAllCity());
		ast.setAreaCache(areaMapper.selectAllDistrict());
	}


}






