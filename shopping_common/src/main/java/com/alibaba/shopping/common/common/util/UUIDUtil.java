package com.alibaba.shopping.common.common.util;

import java.util.UUID;

/**
 * 生成UUID
 * @author 盛凯 2018-10-31
 */
public class UUIDUtil {

	public static String buildUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
	    return uuid;
	}
	
}
