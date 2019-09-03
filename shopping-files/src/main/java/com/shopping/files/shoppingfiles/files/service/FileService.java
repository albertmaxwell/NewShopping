package com.shopping.files.shoppingfiles.files.service;

import com.alibaba.shopping.common.common.enums.ErrorCode;
import com.alibaba.shopping.common.common.exception.ResultException;
import com.alibaba.shopping.common.common.model.UploadModel;
import com.alibaba.shopping.common.common.util.FileUtils;
import com.alibaba.shopping.common.common.vo.ResultVo;
import com.alibaba.shopping.common.common.vo.factory.ResultVoFactory;
import com.shopping.files.shoppingfiles.files.consts.FileUploadConst;
import com.shopping.files.shoppingfiles.files.dao.FileDao;
import com.shopping.files.shoppingfiles.files.entity.FileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class FileService {

	private Logger logger = LoggerFactory.getLogger(FileService.class);

	@Autowired
	private FileDao fileDao;
	
	@Value("${file.path}")
	private String filePath;
	@Value("${web.file.url}")
	private String webFileUrl;
	@Value("${file.server.url}")
	private String fileServerUrl;
	
	/**
	 * 上传文件
	 * 
	 * @param uploadModel
	 * @return
	 */
	public ResultVo uploadFile(UploadModel uploadModel) throws ResultException {
		ResultVo resultVo = null;
		
		String fileName = FileUtils.buildFileName(uploadModel.getSuffix(), null);
		String content = uploadModel.getContent();
		String channel = uploadModel.getChannel();
		String id = uploadModel.getId();
		
		//保存文件
		String path = FileUtils.buildSavePath(filePath, channel);
		File file = null;
		try {
			//文件转码
			byte[] bytes = Base64.getDecoder().decode(content);
			file = FileUtils.getFile(bytes, path, fileName);
		} catch (Exception e) {
			logger.error("保存文件时发生异常：" + e.getMessage());
			e.printStackTrace();
		}
		if(file != null) {
			String url = path.replace(filePath, webFileUrl).replace("\\", "/") + fileName;
			FileUpload fileUpload = new FileUpload();
			fileUpload.setId(id);
			fileUpload.setUrl(url);
			fileUpload.setChannel(channel);
			fileUpload.setCreateTime(new Date());
			fileUpload.setSync(FileUploadConst.SYNC_YES);
			//保存到数据库
			try {
				fileUpload = fileDao.save(fileUpload);
				logger.info("文件上传：文件id={}，已上传至服务器！", id);
				resultVo = ResultVoFactory.success(null, null);
				return resultVo;
			} catch (Exception e) {
				e.printStackTrace();
				throw new ResultException(ErrorCode.ERROR.getCode(), "数据保存异常");
			}
		} else {
			throw new ResultException(ErrorCode.ERROR.getCode(), "存储失败！");
		}
	}
	
	/**
	 * 根据id获取文件信息
	 * 
	 * @param id
	 * @return
	 */
	public ResultVo<FileUpload> findById(String id) throws ResultException {
		ResultVo<FileUpload> resultVo = new ResultVo<FileUpload>();
		try {
			Optional<FileUpload> fileUpload = fileDao.findById(id);
			FileUpload fu = null;
			if(fileUpload.isPresent()) {
				fu = fileUpload.get();
				if(fu != null) {
					String url = fu.getUrl();
					if(fu.getSync() == FileUploadConst.SYNC_NO) {
						//如果是未同步，直接取路径（绝对路径）即可
						fu.setUrl(url);
					} else {
						//已同步，则需要拼接成文件服务器路径
						fu.setUrl(fileServerUrl + url);
					}
				}
			}
			resultVo = ResultVoFactory.success(fu, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResultException(ErrorCode.ERROR.getCode(), "查询失败");
		}
		return resultVo;
	}
	
	/**
	 * 根据id集合获取文件信息
	 * 
	 * @param ids
	 * @return
	 */
	public ResultVo<List<FileUpload>> findByIds(List<String> ids) throws ResultException {
		ResultVo<List<FileUpload>> resultVo = new ResultVo<List<FileUpload>>();
		try {
			List<FileUpload> fileUploads = fileDao.findByIdIn(ids);
			for(int i=0; i<fileUploads.size(); i++) {
				String url = fileUploads.get(i).getUrl();
				if(fileUploads.get(i).getSync() == FileUploadConst.SYNC_NO) {
					//如果是未同步，直接取路径（绝对路径）即可
					fileUploads.get(i).setUrl(url);
				} else {
					//已同步，则需要拼接成文件服务器路径
					fileUploads.get(i).setUrl(fileServerUrl + url);
				}
			}
			resultVo = ResultVoFactory.success(fileUploads, null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResultException(ErrorCode.ERROR.getCode(), "查询失败");
		}
		return resultVo;
	}

	/**
	 * 文件信息存储
	 * 用于传输文件之前，文件还存储在项目本地时
	 *
	 * @param uploadModel
	 * @return
	 */
	public ResultVo fileInfoSave(UploadModel uploadModel) throws ResultException {
		ResultVo resultVo = null;

		String fileName = FileUtils.buildFileName(uploadModel.getSuffix(), null);
		String channel = uploadModel.getChannel();
		String id = uploadModel.getId();

		Optional<FileUpload> optional = fileDao.findById(id);
		FileUpload fileUpload = null;
		if(!optional.isPresent()) {
			fileUpload = new FileUpload();
			fileUpload.setId(id);
		} else {
			fileUpload = optional.get();
		}
		fileUpload.setUrl(uploadModel.getUrl());
		fileUpload.setChannel(channel);
		fileUpload.setCreateTime(new Date());
		fileUpload.setSync(FileUploadConst.SYNC_NO);
		//保存到数据库
		try {
			fileUpload = fileDao.save(fileUpload);
			logger.info("文件信息存储：文件id={}，信息已存在服务器！", id);
			resultVo = ResultVoFactory.success(null, null);
			return resultVo;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResultException(ErrorCode.ERROR.getCode(), "数据保存异常");
		}
	}
}
