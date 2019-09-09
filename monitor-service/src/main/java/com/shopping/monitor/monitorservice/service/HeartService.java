package com.shopping.monitor.monitorservice.service;



/**
 * 类描述：部分字符解析解析
 * Created by 李泽阳 on 2019/8/6
 */

public class HeartService {
    /**
     * 转换端口地址
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String analyzeAddress(String url) throws Exception {
        StringBuffer str = new StringBuffer(url);
        Integer sta = str.indexOf("_");
        str.replace(sta, sta + 1, ":");
        String ipPort = str.toString();
        return ipPort;
    }
}
