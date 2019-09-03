package com.shoppingfilesplugin.shoppingfilesplugin.plugin.listener;


import com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner.FilePluginRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 随系统一同启动文件服务器组件
 * @author 盛凯 2018-11-1
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class FileUploadListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationRunner {

	@Autowired
	private FilePluginRunner filePluginRunner;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 防止启动两次
        if (event.getApplicationContext().getParent() != null) {
        	startFiles();
        }
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		startFiles();
	}

	private void startFiles() {
		//启用文件服务器组件
		filePluginRunner.start();
	}
	
}
