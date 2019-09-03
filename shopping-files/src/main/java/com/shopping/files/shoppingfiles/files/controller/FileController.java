package com.shopping.files.shoppingfiles.files.controller;



import com.alibaba.shopping.common.common.enums.ErrorCode;
import com.alibaba.shopping.common.common.exception.ResultException;
import com.alibaba.shopping.common.common.model.UploadModel;
import com.alibaba.shopping.common.common.vo.ResultVo;
import com.shopping.files.shoppingfiles.files.entity.FileUpload;
import com.shopping.files.shoppingfiles.files.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="v1")
public class FileController {

	@Value("${file.server.url}")
	private String serverUrl;
	@Value("${web.file.url}")
	private String webFileUrl;
	@Value("${file.path}")
	private String filePath;
	
	@Autowired
	private FileService fileService;
	
	//文件上传到服务端
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public ResultVo fileUpload(@RequestBody UploadModel uploadModel) {
		ResultVo resultVo = null;
		try {
			if(StringUtils.isEmpty(uploadModel.getId()) 
					|| StringUtils.isEmpty(uploadModel.getSuffix())
					|| StringUtils.isEmpty(uploadModel.getContent())
					|| StringUtils.isEmpty(uploadModel.getChannel())) {
				throw new ResultException(ErrorCode.PARAM_ERROR.getCode(), "参数错误");
			}
			resultVo = fileService.uploadFile(uploadModel);
		} catch (ResultException e) {
			e.printStackTrace();
			resultVo = e.getResultVO();
		}
		return resultVo;
	}
	
	//根据文件id查询文件信息
	@RequestMapping(value="find/{id}", method=RequestMethod.GET)
	public ResultVo<FileUpload> findById(@PathVariable(value="id", required=true) String id) {
		ResultVo<FileUpload> resultVo = null;
		try {
			resultVo = fileService.findById(id);
		} catch (ResultException e) {
			e.printStackTrace();
			resultVo = e.getResultVO();
		}
		return resultVo;
	}
	
	//根据文件id查询文件信息
	@RequestMapping(value="finds", method=RequestMethod.GET)
	public ResultVo<List<FileUpload>> findByIds(@RequestParam(name="ids") String ids) {
		List<String> idList = null;
		if(!StringUtils.isEmpty(ids)) {
			String[] idArr = ids.split(",");
			idList = Arrays.asList(idArr);
		}
		ResultVo<List<FileUpload>> resultVo = null;
		try {
			resultVo = fileService.findByIds(idList);
		} catch (ResultException e) {
			e.printStackTrace();
			resultVo = e.getResultVO();
		}
		return resultVo;
	}
	
	//根据文件id获取图片文件流
	@Deprecated
	@RequestMapping(value="image/jpeg/{id}", method=RequestMethod.GET)
	public void getStreamById(@PathVariable(value="id", required=true) String id, HttpServletResponse response) {
		ResultVo<FileUpload> resultVo = null;
		try {
			resultVo = fileService.findById(id);
			if(resultVo.isOk()) {
				FileUpload fileUpload = resultVo.getData();
				String replace = serverUrl + webFileUrl;
				String path = fileUpload.getUrl().replace(replace, filePath);
				File file = new File(path);
				if(file.exists()) {
					InputStream fis = new BufferedInputStream(new FileInputStream(file));
		            byte[] buffer = new byte[fis.available()];
		            fis.read(buffer);
		            fis.close();
		            response.reset();
		            // 设置response的Header
		            response.addHeader("Content-Length", "" + file.length());
		            response.setContentType("image/jpeg");

		            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
		            toClient.write(buffer);
		            toClient.flush();
		            toClient.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//文件信息传输
	@RequestMapping(value="fileInfoSave", method=RequestMethod.POST)
	public ResultVo fileInfoSave(@RequestBody UploadModel uploadModel) {
		ResultVo resultVo = null;
		try {
			if(StringUtils.isEmpty(uploadModel.getId())
					|| StringUtils.isEmpty(uploadModel.getSuffix())
					|| StringUtils.isEmpty(uploadModel.getUrl())
					|| StringUtils.isEmpty(uploadModel.getChannel())) {
				throw new ResultException(ErrorCode.PARAM_ERROR.getCode(), "参数错误");
			}
			resultVo = fileService.fileInfoSave(uploadModel);
		} catch (ResultException e) {
			e.printStackTrace();
			resultVo = e.getResultVO();
		}
		return resultVo;
	}

}
