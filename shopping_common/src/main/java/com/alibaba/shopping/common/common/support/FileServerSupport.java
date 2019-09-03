package com.alibaba.shopping.common.common.support;

import com.alibaba.shopping.common.common.util.HttpClientUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Map;

/**
 * 文件服务器支持
 * @author 盛凯 2018-11-23
 */
public class FileServerSupport {
	
	/**
	 * 根据文件id，从文件服务器获取图片路径
	 * @param fileServerUrl 文件服务器url（注意，不是全地址，而是url）
	 * @param id 文件id
	 * @return
	 */
	public static String getUrlByFileId(String fileServerUrl, String id) {
		Gson gson = new Gson();
		//文件查询地址
		String url = fileServerUrl + "/v1/find/" + id;
		try {
			String result = HttpClientUtil.sendGet(url, null, null);
			if(result != null) {
			    Map<String, Object> map = gson.fromJson(result, Map.class);
			    String code = map.get("code").toString();
			    if(10000 == Integer.valueOf(code.substring(0, code.indexOf(".")))) {
			    	if(map.get("data") != null) {
			    		Map<String, String> data = gson.fromJson(gson.toJson(map.get("data")), Map.class);
			    		return data.get("url");
			    	}
			    }
			}
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
