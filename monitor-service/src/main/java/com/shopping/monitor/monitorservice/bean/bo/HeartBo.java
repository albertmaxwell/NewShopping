package com.shopping.monitor.monitorservice.bean.bo;

import java.io.Serializable;

/**
 * 类描述：心跳传输bean对象
 * Created by 金海洋 on 2019/8/6
 */
public class HeartBo implements Serializable {

    private String heartKey;//传输心跳key值
    private String url;//发送项目地址


    public String getHeartKey() {
        return heartKey;
    }

    public void setHeartKey(String heartKey) {
        this.heartKey = heartKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
