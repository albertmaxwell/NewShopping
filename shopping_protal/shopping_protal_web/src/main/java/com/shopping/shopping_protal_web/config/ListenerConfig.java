package com.shopping.shopping_protal_web.config;

import com.shopping.shopping_protal_web.listener.CountListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拦截器
 * @author 金海洋
 * @date 2019/8/18  -17:19
 */

@Configuration
public class ListenerConfig {

	@Bean
	public ServletListenerRegistrationBean<CountListener>
	countListenerServletRegistrationBean(){
		return new ServletListenerRegistrationBean<CountListener>(
				new CountListener());
	}


}
