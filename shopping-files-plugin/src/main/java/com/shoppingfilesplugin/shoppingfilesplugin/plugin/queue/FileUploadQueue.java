package com.shoppingfilesplugin.shoppingfilesplugin.plugin.queue;

import com.alibaba.shopping.common.common.queue.BaseQueue;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.bo.FileUploadBo;

/**
 * 文件传输队列
 * 用于向文件服务器传输文件	
 * @author 盛凯 2018-10-30
 *
 */
public class FileUploadQueue extends BaseQueue<FileUploadBo> {
	
	private static final FileUploadQueue INSTANCE = new FileUploadQueue();

	private FileUploadQueue() {
	}

	public static FileUploadQueue getInstance() {
		return INSTANCE;
	}

}
