package com.shoppingfilesplugin.shoppingfilesplugin.plugin.task;


import com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner.FilePluginConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 本地文件任务
 * @author 盛凯 2019-3-26
 */
@Component
public class LocalFileTask {
    private Logger logger = LoggerFactory.getLogger(LocalFileTask.class);

    @Value("${files.local.day:7}")
    private int filesLocalDay;

    /**
     * 删除本地过期文件
     */
    @Async
    @Scheduled(cron = "0 0/1 * * * ?")
    public void delLocalExpFile() {
        if(filesLocalDay != -1) {
            FilePluginConfig fpc = FilePluginConfig.getInstance();
            String path = fpc.getFilePath();
            List<String> filePaths = recursiveFiles(path);
            if(filePaths != null && filePaths.size() > 0) {
                for(String filePath : filePaths) {
                    filePath = filePath.replace("\\", "/");
                    try {
                        //截取时间戳
                        String timeStr = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf("/") + 14);
                        Long time = Long.valueOf(timeStr);
                        Date date = new Date(time);
                        Date expDate = new Date();
                        expDate.setTime(expDate.getTime() - (1000 * 60 * 60 * 24 * filesLocalDay));
                        if(date.getTime() <= expDate.getTime()) {
                            //文件过期，删除
                            File f = new File(filePath);
                            f.delete();
                            logger.info("文件定期清理>>>path={}，已被删除！", filePath);
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 递归获取文件夹下所有文件
     *
     * @param path 文件路径
     */
    private List<String> recursiveFiles(String path){
        List<String> result = new ArrayList<>();
        // 创建 File对象
        File file = new File(path);

        // 取 文件/文件夹
        File files[] = file.listFiles();

        // 对象为空 直接返回
        if(files == null){
            return result;
        }

//        if(files.length == 0) {
//            //如果文件夹下面没文件，把文件夹删掉
//            file.delete();
//        }

        // 存在文件 遍历 判断
        for (File f : files) {
            // 判断是否为 文件夹
            if(f.isDirectory()){
                // 为 文件夹继续遍历
                result.addAll(recursiveFiles(f.getAbsolutePath()));
            } else if(f.isFile()){
                // 判断是否为 文件
                result.add(f.getAbsolutePath());
            }
        }
        return result;
    }
}
