package com.shoppingfilesplugin.shoppingfilesplugin.plugin.controller;


import com.alibaba.shopping.common.common.enums.ErrorCode;
import com.alibaba.shopping.common.common.exception.ResultException;
import com.alibaba.shopping.common.common.vo.ResultVo;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner.FilePluginConfig;
import com.shoppingfilesplugin.shoppingfilesplugin.plugin.service.FileServicePluginFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文件访问服务
 * @author 盛凯 2018-11-1
 *
 */
@RestController
@RequestMapping("file_plugin")
public class FileNewController {
	
	@Autowired
	private FileServicePluginFiles fileServicePluginFiles;
	@Value("${files.controller.enable:false}")
	private boolean controllerEnable;
	
	/**
	 * 文件上传
	 * @param file
	 * @param suffix
	 * @return
	 */
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public ResultVo upload(@RequestParam("file") MultipartFile file
			, @RequestParam("suffix") String suffix
			, @RequestParam(value = "busName", required = false) String busName //业务名
			, HttpServletRequest request) {
		ResultVo resultVo = null;
		
		if(!controllerEnable) {
			resultVo = new ResultVo();
			resultVo.setCode(ErrorCode.ERROR.getCode());
			resultVo.setMessage("文件服务未开启");
			return resultVo;
		}
		
		String path = request.getContextPath();
		FilePluginConfig fpc = FilePluginConfig.getInstance();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/" + fpc.getFileWebPrefix() + "/";
		try {
			if(file == null || StringUtils.isEmpty(suffix)) {
				throw new ResultException(ErrorCode.PARAM_ERROR.getCode(), "参数错误");
			}
			resultVo = fileServicePluginFiles.upload(file, suffix, basePath, busName);
		} catch (ResultException e) {
			e.printStackTrace();
			resultVo = e.getResultVO();
		}
		return resultVo;
	}
	
	@RequestMapping(value = "/find", method={RequestMethod.GET} ,produces={"application/json"})
	public Map find(@RequestParam(value="id", required=true) String id) {
		Map result = null;
		try {
			result = fileServicePluginFiles.find(id);
		} catch (Exception e) {
			e.printStackTrace();
//			result.put("code", 500);
//			result.put("message", "接口访问异常");
//			result.put("ok", false);
//			result.put("data", null);
		}
		return result;
	}
	
	@RequestMapping(value = "/finds", method={RequestMethod.GET} ,produces={"application/json"})
	public Map finds(@RequestParam(value="ids", required=true) String ids) {
		Map result = null;
		try {
			result = fileServicePluginFiles.finds(ids);
		} catch (Exception e) {
			e.printStackTrace();
//			result.put("code", 500);
//			result.put("message", "接口访问异常");
//			result.put("ok", false);
//			result.put("data", null);
		}
		return result;
	}
	
	/**
	 * 多文件上传
	 * @param file
	 * @param suffix
	 * @return
	 */
	@RequestMapping(value="uploads", method=RequestMethod.POST)
	public ResultVo uploads(@RequestParam("file") List<MultipartFile> file
			, @RequestParam("suffix") String suffix
			, @RequestParam(value = "busName", required = false) String busName //业务名
			, HttpServletRequest request) {
		ResultVo resultVo = new ResultVo<>();
		resultVo.setOk(true);
		if(!controllerEnable) {
			resultVo = new ResultVo();
			resultVo.setCode(ErrorCode.ERROR.getCode());
			resultVo.setMessage("文件服务未开启");
			resultVo.setOk(false);
			return resultVo;
		}
		String[] s = suffix.split(",");
		if(file.size() != s.length) {
			resultVo = new ResultVo();
			resultVo.setCode(ErrorCode.ERROR.getCode());
			resultVo.setMessage("文件与后缀不对应");
			resultVo.setOk(false);
			return resultVo;
		}
		
		//传输文件
		List<String> ids = new ArrayList<>();
		for(int i=0; i<file.size(); i++) {
			ResultVo<String> temp = upload(file.get(i), s[i], busName, request);
			if(10000 == temp.getCode()) {
				ids.add(temp.getData());
			} else {
				resultVo.setMessage("部分文件未上传");
			}
		}
		resultVo.setData(ids);
		return resultVo;
	}


	/**
	 * 多文件上传
	 * @param file
	 * @param suffix
	 * @return
	 */
	@RequestMapping(value="/swfUploads", method=RequestMethod.POST)
	public ResultVo swfUploads(MultipartFile Filedata,HttpServletRequest request,
							   HttpServletResponse response, String ID,
							   String Filename , String album_id) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		//MultipartFile multipartFile = (MultipartFile) request;

		List<MultipartFile> file=new ArrayList<>();
		file.add(Filedata);
		String suffix="png";
		String busName="业务图片";
		ResultVo resultVo = new ResultVo<>();
		resultVo.setOk(true);
		if(!controllerEnable) {
			resultVo = new ResultVo();
			resultVo.setCode(ErrorCode.ERROR.getCode());
			resultVo.setMessage("文件服务未开启");
			resultVo.setOk(false);
			return resultVo;
		}
		String[] s = suffix.split(",");
		if(file.size() != s.length) {
			resultVo = new ResultVo();
			resultVo.setCode(ErrorCode.ERROR.getCode());
			resultVo.setMessage("文件与后缀不对应");
			resultVo.setOk(false);
			return resultVo;
		}

		//传输文件
		List<String> ids = new ArrayList<>();
		for(int i=0; i<file.size(); i++) {
			ResultVo<String> temp = upload(file.get(i), s[i], busName, request);
			if(10000 == temp.getCode()) {
				ids.add(temp.getData());
			} else {
				resultVo.setMessage("部分文件未上传");
			}
		}
		resultVo.setData(ids);

		return resultVo;

	}
}
