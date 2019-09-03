package com.alibaba.shopping.common.common.util;



import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Calendar;

/**
 * 文件工具类
 * @author 盛凯 2018-10-24
 */
public class FileUtils {

	/** 
     * 获得指定文件的byte数组 
     */  
    public static byte[] getBytes(File file){  
        byte[] buffer = null;  
        try {  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
            byte[] b = new byte[1000];  
            int n;  
            while ((n = fis.read(b)) != -1) {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return buffer;  
    }
    
    /** 
     * 根据byte数组，生成文件 
     */  
    public static File getFile(byte[] bfile, String filePath,String fileName) {  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try {  
            File dir = new File(filePath);  
            if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在  
                dir.mkdirs();  
            }  
			file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(bfile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (bos != null) {  
                try {  
                    bos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
            if (fos != null) {  
                try {  
                    fos.close();  
                } catch (IOException e1) {  
                    e1.printStackTrace();  
                }  
            }  
        }  
        return file;
    }  
    
    /**
     * 根据文件名获取文件后缀
     * @param name
     * @return
     */
    public static String getFileSuffix(String name) {
    	return name.substring(name.lastIndexOf(".") + 1, name.length());
    }
    
    /**
     * 生成文件名
     * @param suffix 后缀
     * @param busName 业务名
     * @return
     */
    public static String buildFileName(String suffix, String busName) {
        if(StringUtils.isEmpty(busName)) {
            return System.currentTimeMillis() + "_" + RandomUtil.random(4) + "." + suffix;
        } else {
            return System.currentTimeMillis() + "_" + busName + "_" + RandomUtil.random(4) + "." + suffix;
        }
    }

    /**
	 * 生成存储文件的目录
	 * @param filePath
	 * @return
	 */
	public static String buildSavePath(String filePath) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		String path = filePath + File.separator
				+ year + File.separator  //年
				+ month + File.separator  //月
				+ date + File.separator;  //日
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		return path;
	}
    
	/**
	 * 生成存储文件的目录
	 * @param filePath
	 * @param channel 渠道
	 * @return
	 */
	public static String buildSavePath(String filePath, String channel) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		String path = filePath + File.separator
				+ channel + File.separator //渠道
				+ year + File.separator  //年
				+ month + File.separator  //月
				+ date + File.separator;  //日
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		return path;
	}
	
}
