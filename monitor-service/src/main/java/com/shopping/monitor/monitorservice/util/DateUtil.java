package com.shopping.monitor.monitorservice.util;

import java.util.Date;

/**
 * 类描述：日期格式公共类
 * Created by 李泽阳 on 2019/8/6
 */
public class DateUtil {


    /**
     * 将long转换为date
     *
     * @param lo
     * @return
     */
    public static Date longToDate(long lo) {
        Date date = new Date(lo);
        return date;
    }
}
