package com.shoppingfilesplugin.shoppingfilesplugin.plugin.bo;

/**
 * 文件传输逻辑bean
 * @author 盛凯 2018-10-31
 */
public class FileUploadBo {

	private String id; //文件的id
	private String localPath; //本地磁盘的路径
	private String suffix; //后缀
	private String channel; //渠道
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocalPath() {
		return localPath;
	}
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

}
