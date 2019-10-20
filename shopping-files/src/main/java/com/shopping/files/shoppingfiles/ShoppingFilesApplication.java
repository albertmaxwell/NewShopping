package com.shopping.files.shoppingfiles;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class ShoppingFilesApplication {
	private static java.util.logging.Logger logger = Logger.getLogger(String.valueOf(ShoppingFilesApplication.class));

	public static void main(String[] args) {
		SpringApplication.run(ShoppingFilesApplication.class, args);
		logger.info(">>>>>>>>>>>>>>文件服务器启动成功<<<<<<<<<<<<<");
	}

}
