package com.shopping.shopping_protal_web.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 金海洋
 * @date 2019/8/18  -18:08
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)//监听器  监听启动类
public class ApplyUpLoadListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationRunner {
	@Override
	public void run(ApplicationArguments args) throws Exception {

	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
			System.out.println("加载数据中..........");
	}
}
