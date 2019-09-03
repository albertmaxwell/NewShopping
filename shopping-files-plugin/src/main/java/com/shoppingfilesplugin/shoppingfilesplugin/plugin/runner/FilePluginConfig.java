package com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner;

public class FilePluginConfig {

	private static FilePluginConfig instance;
	
	public static FilePluginConfig getInstance() {
		if(instance == null) {
			instance = new FilePluginConfig();
		}
		return instance;
	}
	
	/*必填*/
	private String channel; //渠道
	private String filesServerUrl; //文件服务器地址
	private String filePath; //文件存储路径
	
	/*选填*/
	private String fileWebPrefix = null; //wen访问本地临时文件资源前缀
	private int uploadErrReConnCount = 5; //文件服务器接口调用失败，接口重试次数
	private int uploadErrReConnSecond = 60; //文件服务器接口调用失败，接口重试等待秒数
	private boolean enable = true; //是否开启服务器文件传输
	private String tableName = "file_temp_"; //表名
	
	private FilePluginConfig(){}

	public String getChannel() {
		return channel;
	}

	void setChannel(String channel) {
		this.channel = channel;
	}

	public String getFilesServerUrl() {
		return filesServerUrl;
	}

	void setFilesServerUrl(String filesServerUrl) {
		this.filesServerUrl = filesServerUrl;
	}

	public String getFilePath() {
		return filePath;
	}

	void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileWebPrefix() {
		return fileWebPrefix;
	}

	void setFileWebPrefix(String fileWebPrefix) {
		this.fileWebPrefix = fileWebPrefix;
	}

	public int getUploadErrReConnCount() {
		return uploadErrReConnCount;
	}

	void setUploadErrReConnCount(int uploadErrReConnCount) {
		this.uploadErrReConnCount = uploadErrReConnCount;
	}

	public int getUploadErrReConnSecond() {
		return uploadErrReConnSecond;
	}

	void setUploadErrReConnSecond(int uploadErrReConnSecond) {
		this.uploadErrReConnSecond = uploadErrReConnSecond;
	}

	public boolean isEnable() {
		return enable;
	}

	void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getTableName() {
		return tableName;
	}

	void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
