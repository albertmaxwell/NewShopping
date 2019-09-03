package com.alibaba.shopping.common.common.util;

import java.util.List;
import java.util.Map;

public class ListUtil {

	public static boolean isEmpty(List list) {
		if(list == null || list.size() == 0) {
			return true;
		}
		return false;
	}

	public static boolean notEmpty(List list) {
		if(list != null && list.size() > 0) {
			return true;
		}
		return false;
	}
	
	public static Map getListOne(List list) {
		if(notEmpty(list)) {
			return (Map)list.get(0);
		}
		return null;
	}
}
