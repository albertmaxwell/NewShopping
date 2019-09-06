package com.shoppingfilesplugin.shoppingfilesplugin.plugin.service;


import com.alibaba.shopping.common.common.enums.ErrorCode;
import com.alibaba.shopping.common.common.exception.ResultException;
import com.alibaba.shopping.common.common.model.UploadModel;
import com.alibaba.shopping.common.common.util.FileUtils;
import com.alibaba.shopping.common.common.util.HttpClientUtil;
import com.alibaba.shopping.common.common.util.UUIDUtil;
import com.alibaba.shopping.common.common.vo.ResultVo;
import com.alibaba.shopping.common.common.vo.factory.ResultVoFactory;
import com.google.gson.Gson;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.bo.FileUploadBo;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.dao.FileUploadTempDao;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.queue.FileUploadQueue;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner.FilePluginConfig;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.util.JsonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileService {

	private Logger logger = LoggerFactory.getLogger(FileService.class); 
	
	@Value("${files.server.url}")
	private String fileServerUrl;
	@Value("${files.path}")
	private String filePath;
	
	@Autowired
	private FileUploadTempDao fileUploadTempDao;
	
	/**
	 * 上传文件到本地，并通知文件服务器
	 * @param file 文件
	 * @param suffix 后缀
	 * @param localUrl 本地url
	 * @param busName 业务名
	 * @return
	 */
	public ResultVo upload(MultipartFile file, String suffix, String localUrl, String busName) throws ResultException {
		ResultVo resultVo = null;
		FilePluginConfig fpc = FilePluginConfig.getInstance();
		//保存文件至本地
		String fileName = FileUtils.buildFileName(suffix, busName);
		String path = FileUtils.buildSavePath(fpc.getFilePath()) + fileName;
		//把文件保存在文件服务器
		File localFile = new File(path);
		try {
			//保存文件
			file.transferTo(localFile);
			//本地url转远程路径
			String url = null;
			if(!StringUtils.isEmpty(fpc.getFileWebPrefix())) {
                url = localUrl + path.replace(fpc.getFilePath(), "").replace("\\", "/");
            }
			//保存临时表记录
			String uuid = UUIDUtil.buildUUID();
			//每上传一个文件就把文件保存在当前服务的数据库的表中
			fileUploadTempDao.saveFileUploadTemp(uuid, url, localFile.getPath());
			//然后打印日志
			logger.info("文件已存入本地：uuid={}", uuid);
			//文件信息保存成功，加入传输队列
			if(fpc.isEnable()) {
				FileUploadBo fileUploadBo = new FileUploadBo();
				fileUploadBo.setId(uuid);
				fileUploadBo.setSuffix(suffix);
				fileUploadBo.setLocalPath(path);
				fileUploadBo.setChannel(fpc.getChannel());
				//发送文件消息给服务器
				fileInfoMsg(fileUploadBo, url);
				FileUploadQueue.getInstance().offer(fileUploadBo);
				logger.info("文件已加入上传队列！uuid={}", uuid);
			}
			resultVo = ResultVoFactory.success(uuid, null);
			return resultVo;
		} catch (IOException e) {
			logger.error("文件上传发生错误！");
			e.printStackTrace();
			throw new ResultException(ErrorCode.ERROR.getCode(), "发生错误，请稍后再试！");
		}
	}
	
	/**
	 * 根据文件id读取文件信息
	 * @param id 文件id
	 * @return
	 */
	public Map find(String id) throws Exception {
		//url拼接
		String url = fileServerUrl + "/v1/find/" + id;
		String result = HttpClientUtil.sendGet(url, null, null);
		if(result != null) {
			Gson gson = new Gson();
			Map map = gson.fromJson(result, Map.class);
	        logger.info("根据文件id查询文件信息>>>id={}, result={}", id, result);
	        return map;
		} else {
			throw new Exception("文件查询失败");
		}
	}
	
	/**
	 * 根据文件ids读取多个文件信息
	 * @param ids 文件ids
	 * @return
	 */
	public Map finds(String ids) throws Exception {
		//url拼接
		String url = fileServerUrl + "/file_plugin/finds";
		Map<String, String> params = new HashMap<>();
		params.put("ids", ids);
		String result = HttpClientUtil.sendGet(url, params, null);
		if(result != null) {
			Gson gson = new Gson();
			Map map = gson.fromJson(result, Map.class);
	        logger.info("根据文件id查询文件信息>>>ids={}, result={}", ids, result);
	        return map;
		} else {
			throw new Exception("文件查询失败");
		}
	}

	//文件信息告知文件服务器
	private void fileInfoMsg(FileUploadBo bo, String url) {
		FilePluginConfig fpc = FilePluginConfig.getInstance();
		UploadModel um = new UploadModel();
		um.setId(bo.getId());
		um.setSuffix(bo.getSuffix());
		um.setChannel(bo.getChannel());
		um.setUrl(url);
		String json = JsonUtil.toJsonString(um);
		String sendUrl = fpc.getFilesServerUrl() + "v1/fileInfoSave";
		//上传到文件服务器
		String result = null;
		try {
			result = HttpClientUtil.sendPostToJson(sendUrl, json, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result != null) {
			ResultVo resultVo = JsonUtil.convertJsonObject(result, ResultVo.class);
			if (resultVo.isOk()) {
				logger.info("文件信息传输>>>ID：{}，路径：{}", um.getId(), um.getUrl());
			}
		}
	}
}
