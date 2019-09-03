package com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner;


import com.shoppingfilesplugin.shoppingfilesplugin.plugin.dao.FileUploadTempDao;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.task.FileUploadTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FilePluginRunner {
	
	private Logger logger = LoggerFactory.getLogger(FilePluginRunner.class);
	
	private static boolean isStart = false;

	@Value("${files.channel}")
	private String filesChannel;
	@Value("${files.server.url}")
	private String filesServerUrl;
	@Value("${files.path}")
	private String filesPath;
	
	@Value("${files.enable:true}")
	private boolean filesEnable;
	@Value("${files.web.prefix:}")
	private String filesWebPrefix;
	@Value("${files.upload.error.reconn.count:5}")
	private int filesUploadErrorReconnCount;
	@Value("${files.upload.error.reconn.second:60}")
	private int filesUploadErrorReconnSecond;
	@Value("${files.table.name:file_temp_${files.channel}}")
	private String filesTableName;
	
	@Autowired
	private FileUploadTask fileUploadTask;
	@Autowired
	private FileUploadTempDao fileUploadTempDao;
	
	public synchronized void start() {
		if(isStart) {
			//防止重复启动
			return;
		}
		try {
			buildConfig();
			fileUploadTempDao.createFileUploadTemp();
			fileUploadTask.findNotUploadToQueue();
			fileUploadTask.fileUploadToFiles();
			isStart = true;
			logger.info("[文件服务器组件]启用成功...");
		} catch (Exception e) {
			logger.info("[文件服务器组件]启用失败！！！");
			e.printStackTrace();
		}
	}
	
	private void buildConfig() throws Exception {
		FilePluginConfig fpc = FilePluginConfig.getInstance();
		//这两个为必填参数
		if(filesChannel == null || "".equals(filesChannel)
				|| filesServerUrl == null || "".equals(filesServerUrl)
				|| filesPath == null || "".equals(filesPath)) {
			return;
		}
		
		fpc.setChannel(filesChannel);
		fpc.setFilesServerUrl(filesServerUrl);
		fpc.setFilePath(filesPath);
		
		//选填参数
		fpc.setEnable(filesEnable);
		fpc.setFileWebPrefix(filesWebPrefix);
		fpc.setUploadErrReConnCount(filesUploadErrorReconnCount);
		fpc.setUploadErrReConnSecond(filesUploadErrorReconnSecond);
		fpc.setTableName(filesTableName);
	}
	
}
