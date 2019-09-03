package com.alibaba.shopping.common.common.util;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {

	//统一配置
	private static PoolingHttpClientConnectionManager connMgr;
	private static RequestConfig requestConfig;
	private static final int MAX_TIMEOUT = 7000;
	static {
		// 设置连接池
		connMgr = new PoolingHttpClientConnectionManager();
		// 设置连接池大小
		connMgr.setMaxTotal(100);
		connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());
 
		RequestConfig.Builder configBuilder = RequestConfig.custom();
		// 设置连接超时
		configBuilder.setConnectTimeout(MAX_TIMEOUT);
		// 设置读取超时
		configBuilder.setSocketTimeout(MAX_TIMEOUT);
		// 设置从连接池获取连接实例的超时
		configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
		// 在提交请求之前 测试连接是否可用
		configBuilder.setStaleConnectionCheckEnabled(true);
		requestConfig = configBuilder.build();
	}
	
	/**
	 * 发送get请求
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 */
	public static String sendGet(String url,Map<String, String> params, Map<String, String> headers) throws Exception{
		
		String resulrStr = null;
		StringBuffer sb = null;
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//设置请求参数
		if(null != params && !params.isEmpty()){
			//遍历map
			sb = new StringBuffer();
			sb.append("?");
			for (Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey() + "=" + entry.getValue() + "&");
			}
			sb.delete(sb.length() - 1, sb.length());
			url = url + sb.toString();
 		}
		
		//创建GET请求方法的实例，并填充url
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);
		
		//加入请求头
		if(headers != null) {
			for(Entry<String, String> m : headers.entrySet()) {
				httpGet.setHeader(m.getKey(), m.getValue());
			}
		}

		try {
			//发送（执行）请求
			CloseableHttpResponse response = httpClient.execute(httpGet);
//			//获取响应头、内容
//			int statusCode =  response.getStatusLine().getStatusCode();
//			//打印状态码
//			logger.info("执行状态码："+statusCode);
			org.apache.http.HttpEntity entity = response.getEntity();
			resulrStr = IOUtils.toString(entity.getContent(),"UTF-8");
			response.close();
		}finally {
			//关闭连接释放资源
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resulrStr;
	}

	/**
	 * 发送post请求
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 */
	public static String sendPost(String url,Map<String, String> params, Map<String, String> headers) throws Exception {

		String resultStr = null;
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建请求方法实例，填充url
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		//加入请求头
		if(headers != null) {
			for(Entry<String, String> m : headers.entrySet()) {
				httpPost.setHeader(m.getKey(), m.getValue());
			}
		}
		//设置请求参数（构造参数队列）
		List<NameValuePair> parmsForm = new ArrayList<NameValuePair>();
		for(Entry<String, String> entry : params.entrySet()){
			parmsForm.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(parmsForm,"UTF-8");
			//为方法实例设置参数队列实体
			httpPost.setEntity(entity);
			//发送（执行）
			CloseableHttpResponse response = httpClient.execute(httpPost);
//			//获取状态码
//			int statusCode = response.getStatusLine().getStatusCode();
//			logger.info("执行状态码："+statusCode);
			//获取响应内容
			HttpEntity httpEntity = response.getEntity();
			resultStr = IOUtils.toString(httpEntity.getContent(), "UTF-8");
			response.close();
		}finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultStr;
	}

	/**
	 * 发送post json参数请求
	 * @param url
	 * @param json
	 * @param headers
	 * @return
	 */
	public static String sendPostToJson(String url, String json, Map<String, String> headers) throws Exception {

		String resultStr = null;
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建请求方法实例，填充url
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
		//加入请求头
		if(headers != null) {
			for(Entry<String, String> m : headers.entrySet()) {
				httpPost.setHeader(m.getKey(), m.getValue());
			}
		}
		StringEntity entity;
		try {
			entity = new StringEntity(json,"UTF-8");
			//为方法实例设置参数队列实体
			httpPost.setEntity(entity);
			//发送（执行）
			CloseableHttpResponse response = httpClient.execute(httpPost);
//			//获取状态码
//			int statusCode = response.getStatusLine().getStatusCode();
//			logger.info("执行状态码："+statusCode);
			//获取响应内容
			org.apache.http.HttpEntity httpEntity = response.getEntity();
			resultStr = IOUtils.toString(httpEntity.getContent(), "UTF-8");
			response.close();
		}finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultStr;
	}

	/**
	 * 发送put请求
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 */
	public static String sendPut(String url,Map<String, String> params, Map<String, String> headers) throws Exception {

		String resultStr = null;
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建请求方法实例，填充url
		HttpPut httpPut = new HttpPut(url);
		httpPut.setConfig(requestConfig);
		httpPut.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		//加入请求头
		if(headers != null) {
			for(Entry<String, String> m : headers.entrySet()) {
				httpPut.setHeader(m.getKey(), m.getValue());
			}
		}
		//设置请求参数（构造参数队列）
		List<NameValuePair> parmsForm = new ArrayList<NameValuePair>();
		for(Entry<String, String> entry : params.entrySet()){
			parmsForm.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(parmsForm,"UTF-8");
			//为方法实例设置参数队列实体
			httpPut.setEntity(entity);
			//发送（执行）
			CloseableHttpResponse response = httpClient.execute(httpPut);
//			//获取状态码
//			int statusCode = response.getStatusLine().getStatusCode();
//			logger.info("执行状态码："+statusCode);
			//获取响应内容
			org.apache.http.HttpEntity httpEntity = response.getEntity();
			resultStr = IOUtils.toString(httpEntity.getContent(), "UTF-8");
			response.close();
		}finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultStr;
	}

	/**
	 * 发送put json参数请求
	 * @param url
	 * @param json
	 * @param headers
	 * @return
	 */
	public static String sendPutToJson(String url, String json, Map<String, String> headers) throws Exception {

		String resultStr = null;
		//创建HttpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//创建请求方法实例，填充url
		HttpPut httpPut = new HttpPut(url);
		httpPut.setConfig(requestConfig);
		httpPut.setHeader("Content-Type", "application/json; charset=utf-8");
		//加入请求头
		if(headers != null) {
			for(Entry<String, String> m : headers.entrySet()) {
				httpPut.setHeader(m.getKey(), m.getValue());
			}
		}
		StringEntity entity;
		try {
			entity = new StringEntity(json,"UTF-8");
			//为方法实例设置参数队列实体
			httpPut.setEntity(entity);
			//发送（执行）
			CloseableHttpResponse response = httpClient.execute(httpPut);
//			//获取状态码
//			int statusCode = response.getStatusLine().getStatusCode();
//			logger.info("执行状态码："+statusCode);
			//获取响应内容
			org.apache.http.HttpEntity httpEntity = response.getEntity();
			resultStr = IOUtils.toString(httpEntity.getContent(), "UTF-8");
			response.close();
		}finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultStr;
	}

	/**
	 * 发送delete请求
	 * @param url
	 * @param params
	 * @param headers
	 * @return
	 */
	public static String sendDelete(String url, Map<String, String> params, Map<String, String> headers) throws Exception {

		String resultStr = null;
		StringBuffer sb = null;
		//创建httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//设置请求参数
		if(null != params && !params.isEmpty()){
			//遍历map
			sb = new StringBuffer();
			sb.append("?");
			for (Entry<String, String> entry : params.entrySet()) {
				sb.append(entry.getKey() + "=" + entry.getValue() + "&");
			}
			sb.delete(sb.length() - 1, sb.length());
			url = url + sb.toString();
 		}

		//创建方法实例
		HttpDelete httpDelete = new HttpDelete(url);
		httpDelete.setConfig(requestConfig);
		//加入请求头
		if(headers != null) {
			for(Entry<String, String> m : headers.entrySet()) {
				httpDelete.setHeader(m.getKey(), m.getValue());
			}
		}
		//执行
		try {
			CloseableHttpResponse response = httpClient.execute(httpDelete);
//			//获取响应状态码
//			int statusCode = response.getStatusLine().getStatusCode();
//			logger.info(statusCode + "");
			//获取响应内容
			org.apache.http.HttpEntity entity = response.getEntity();
			resultStr = IOUtils.toString(entity.getContent(), "UTF-8");
			response.close();
		}finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultStr;
	}
}