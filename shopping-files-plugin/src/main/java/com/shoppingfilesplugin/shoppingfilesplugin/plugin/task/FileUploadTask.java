package com.shoppingfilesplugin.shoppingfilesplugin.plugin.task;


import com.alibaba.shopping.common.common.model.UploadModel;
import com.alibaba.shopping.common.common.util.FileUtils;
import com.alibaba.shopping.common.common.util.HttpClientUtil;
import com.alibaba.shopping.common.common.util.ListUtil;
import com.alibaba.shopping.common.common.vo.ResultVo;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.bo.FileUploadBo;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.dao.FileUploadTempDao;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.queue.FileUploadQueue;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner.FilePluginConfig;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Base64;
import java.util.List;
import java.util.Map;

/**
 * 上传文件传输任务
 * @author 盛凯 2018-10-31
 */
@Component
public class FileUploadTask {

	private Logger logger = LoggerFactory.getLogger(FileUploadTask.class);
	
	@Autowired
	private FileUploadTempDao fileUploadTempDao;
	
	//读取未上传文件服务器的文件列表
	@Async
	public void findNotUploadToQueue() {
		FilePluginConfig fpc = FilePluginConfig.getInstance();
		if(!fpc.isEnable()) {
			return;
		}
		logger.info(">>>未上传文件服务器列表读取，启动>>>");
		try {
			List<Map<String, Object>> list = fileUploadTempDao.findAll();
			if(ListUtil.notEmpty(list)) {
				for(Map<String, Object> map : list) {
					String id = map.get("id").toString();
					String path = map.get("path").toString();
					File file = new File(path);
					if(file.exists()) {
						String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1
								, file.getName().length());
						FileUploadBo fileUploadBo = new FileUploadBo();
						fileUploadBo.setId(id);
						fileUploadBo.setLocalPath(file.getPath());
						fileUploadBo.setSuffix(suffix);
						fileUploadBo.setChannel(fpc.getChannel());
						FileUploadQueue.getInstance().offer(fileUploadBo);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//定时文件上传
	@Async
	public void fileUploadToFiles() {
		FilePluginConfig fpc = FilePluginConfig.getInstance();
		if(!fpc.isEnable()) {
			return;
		}
		logger.info(">>>队列文件上传，启动>>>");
		while(true) {
			try {
				FileUploadBo fub = FileUploadQueue.getInstance().take();
				
				logger.info("队列文件上传任务>>>id={}，开始传输文件！", fub.getId());
				
				UploadModel um = new UploadModel();
				um.setId(fub.getId());
				um.setSuffix(fub.getSuffix());
				um.setChannel(fub.getChannel());
				File file = new File(fub.getLocalPath());
				if(file.exists()) {
					//文件存在就继续
					String content = Base64.getEncoder().encodeToString(FileUtils.getBytes(file));
					um.setContent(content);
				} else {
					//文件不存在，删除记录，然后继续循环
					fileUploadTempDao.deleteById(fub.getId());
					continue;
				}
				String json = JsonUtil.toJsonString(um);
				String url = fpc.getFilesServerUrl() + "v1/fileUpload";
				//上传到文件服务器
				String result = null;
				try {
					result = HttpClientUtil.sendPostToJson(url, json, null);
				} catch (Exception e) {
					e.printStackTrace();
					logger.info("队列文件上传任务>>>发生异常，进入潮汐模式！");
					for(int i=0; i<fpc.getUploadErrReConnCount(); i++) {
						try {
							Thread.sleep(fpc.getUploadErrReConnSecond() * 1000);
							result = HttpClientUtil.sendPostToJson(url, json, null);
							break;
						} catch (Exception e1) {}
					}
					if(result == null) {
						logger.info("队列文件上传任务>>>上传失败，id={}", fub.getId());
						continue;
					}
				}
				ResultVo resultVo = JsonUtil.convertJsonObject(result, ResultVo.class);
				if(resultVo.isOk()) {
					//删除数据库临时记录
					fileUploadTempDao.deleteById(fub.getId());
					//删除本地文件   2019-3-25开始文件不删除，改由定时器定时删除
					//file.delete();
					logger.info("队列文件上传任务>>>文件：{} 已成功上传到文件服务器！", fub.getLocalPath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
