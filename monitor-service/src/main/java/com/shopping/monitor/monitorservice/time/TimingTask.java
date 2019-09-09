package com.shopping.monitor.monitorservice.time;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 类描述：定时任务
 * Created by 李泽阳 on 2019/8/8
 */
public class TimingTask {
    private Logger logger = LoggerFactory.getLogger(TimingTask.class);


    @Scheduled(cron = "1/5 * * * * *")
    public void task1() {
        logger.info("springtask 定时任务！");
    }

    @Scheduled(initialDelay = 1000, fixedRate = 1 * 1000)
    public void task2() {
        logger.info("springtask 定时任务！");
    }
}
