package com.alibaba.shopping.common.common.util;

import java.util.Map;

/**
 * 用于处理token相关
 * @author 盛凯 2018-10-25
 *
 */
public class TokenUtil {

	/**
	 * 传入参数，获取MD5的Token
	 * @param key 密钥
	 * @param tag 标记（盐）
	 * @param timestamp 时间戳
	 * @return
	 */
	public static String buildToken(String key, String tag, String timestamp) {
		String str = tag + ":" + timestamp + "_" + key;
		return Md5Util.MD5(str);
	}
	
	/**
	 * 将传参加密
	 * @param param
	 * @param channel 渠道
	 * @param key 密钥
	 * @param tag 标记（盐）
	 * @return
	 */
	public static Map<String, String> getFileTokenParam(Map<String, String> param
			, String channel, String key, String tag) {
		String timestamp = System.currentTimeMillis() + "";
		String token = buildToken(key, tag, timestamp);
		param.put("channel", channel);
		param.put("tag", tag);
		param.put("timestamp", timestamp);
		param.put("token", token);
		return param;
	}
}
