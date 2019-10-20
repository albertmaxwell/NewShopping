package com.shopping.shopping_protal_web.listener;

import com.alibaba.shopping.shoppingcommonutils.common.cache.AreaCache;
import com.alibaba.shopping.shoppingcommonutils.common.mapper.AreaMapper;
import com.shopping.files.shoppingfiles.ShoppingFilesApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author 金海洋
 * @date 2019/8/18  -18:08
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)//监听器  监听启动类
public class ApplyUpLoadListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationRunner {
	private static java.util.logging.Logger logger = Logger.getLogger(String.valueOf(ApplyUpLoadListener.class));

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info(">>>>>>>>>>>>>>加载数据中<<<<<<<<<<<<<");

	}


}

