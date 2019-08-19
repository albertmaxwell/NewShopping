package com.alibaba.shopping.common.utils;

/**
 * @author 金海洋
 * @date 2019/8/17  -20:35
 */
public class StringUtil {

	/**
	 * 判断是否是空字符串 null和"" 都返回 true
	 *
	 * @param s
	 * @return
	 * @author Robin Chang
	 */
	public static boolean isEmpty(String s) {
		if (s != null && !s.equals("")) {
			return false;
		}
		return true;
	}



}
