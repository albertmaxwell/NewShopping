package com.shopping.shopping_protal_web.utils;

/**
 * @author 金海洋
 * @date 2019/10/6  -15:45
 */
public class CommonUtils {

	public static Long null2Long(Object s){
		Long v = Long.valueOf(-1L);
		if (s != null) {
			try {
				v = Long.valueOf(Long.parseLong(s.toString()));
			} catch (Exception localException){
			}
		}

		return v;
	}
}
