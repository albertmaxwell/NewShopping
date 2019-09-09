package com.shopping.monitor.monitorservice.runner;

/**
 * 类描述：静态加载类
 * Created by 金海洋 on 2019/8/7
 */
public class HeartPluginConfig {
    public static HeartPluginConfig instance;

    public static HeartPluginConfig getInstance() {
        if (instance == null) {
            instance = new HeartPluginConfig();
        }
        return instance;
    }
    //private String url="/monitor/heartBeatController/beat";//访问路径前缀
    private String url;//请求地址
    private String key;//发送key值
    private String ipPort;//自身IP端口


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        //this.url = ("http://" + url + "/monitor/heartBeatController/beat");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIpPort() {
        return ipPort;
    }

    public void setIpPort(String ipPort) {
        this.ipPort = ipPort;
    }
}
