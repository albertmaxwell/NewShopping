package com.alibaba.shopping.shopping_back_web.controller;

import com.alibaba.shopping.common.exception.BusinessException;
import com.alibaba.shopping.common.json.AjaxJson;
import com.alibaba.shopping.shopping_back_web.constant.ResultEnum;
import com.alibaba.shopping.shopping_back_web.utils.SaveFile;
import com.sun.imageio.plugins.common.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 文件上传服务
 * @author 金海洋
 * @date 2019/8/26  -16:38
 */
@RestController
@RequestMapping("/uploadFile")
@Controller
//@CrossOrigin
public class FileUploadController {

	@Value("${web.upload-path}")
	private String path;

	private Logger logger = LoggerFactory.getLogger(FileUploadController.class);


	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public void fileUpload(@RequestParam("file") MultipartFile file) {
		// 先设定一个放置上传文件的文件夹(该文件夹可以不存在，下面会判断创建)
		String deposeFilesDir = "E:\\ideaproject\\AlibabaShopping\\NewShopping\\shopping_back\\shopping_back_web\\src\\main\\java\\com\\alibaba\\shopping\\shopping_back_web\\common\\picture\\pictureData";
		// 判断文件手否有内容
		if (file.isEmpty()) {
			System.out.println("该文件无任何内容!!!");
		}
		// 获取附件原名(有的浏览器如chrome获取到的是最基本的含 后缀的文件名,如myImage.png)
		// 获取附件原名(有的浏览器如ie获取到的是含整个路径的含后缀的文件名，如C:\\Users\\images\\myImage.png)
		String fileName = file.getOriginalFilename();
		// 如果是获取的含有路径的文件名，那么截取掉多余的，只剩下文件名和后缀名
		int index = fileName.lastIndexOf("\\");
		if (index > 0) {
			fileName = fileName.substring(index + 1);
		}
		// 判断单个文件大于1M
		long fileSize = file.getSize();
		if (fileSize > 1024 * 1024) {
			System.out.println("文件大小为(单位字节):" + fileSize);
			System.out.println("该文件大于1M");
		}
		// 当文件有后缀名时
		if (fileName.indexOf(".") >= 0) {
			// split()中放正则表达式; 转义字符"\\."代表 "."
			String[] fileNameSplitArray = fileName.split("\\.");
			// 加上random戳,防止附件重名覆盖原文件
			fileName = fileNameSplitArray[0] + (int) (Math.random() * 100000) + "." + fileNameSplitArray[1];
		}
		// 当文件无后缀名时(如C盘下的hosts文件就没有后缀名)
		if (fileName.indexOf(".") < 0) {
			// 加上random戳,防止附件重名覆盖原文件
			fileName = fileName + (int) (Math.random() * 100000);
		}
		System.out.println("fileName:" + fileName);

		// 根据文件的全路径名字(含路径、后缀),new一个File对象dest
		File dest = new File(deposeFilesDir + fileName);
		// 如果该文件的上级文件夹不存在，则创建该文件的上级文件夹及其祖辈级文件夹;
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			// 将获取到的附件file,transferTo写入到指定的位置(即:创建dest时，指定的路径)
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("文件的全路径名字(含路径、后缀)>>>>>>>" + deposeFilesDir + fileName);
	}

	/**
	 *
	 * @param files
	 */
	@RequestMapping(value = "/mulFileUpload", method = RequestMethod.POST)
	public void mulFileUpload(@RequestParam("fileName") MultipartFile[] files) {
		// 先设定一个放置上传文件的文件夹(该文件夹可以不存在，下面会判断创建)
		String deposeFilesDir = "E:\\AAAAA\\picture\\morepic";

		for (MultipartFile file : files) {
			// 判断文件是否有内容
			if (file.isEmpty()) {
				System.out.println("该文件无任何内容!!!");
			}
			// 获取附件原名(有的浏览器如chrome获取到的是最基本的含 后缀的文件名,如myImage.png)
			// 获取附件原名(有的浏览器如ie获取到的是含整个路径的含后缀的文件名，如C:\\Users\\images\\myImage.png)
			String fileName = file.getOriginalFilename();
			// 如果是获取的含有路径的文件名，那么截取掉多余的，只剩下文件名和后缀名
			if (fileName.indexOf("\\") > 0) {
				int index = fileName.lastIndexOf("\\");
				fileName = fileName.substring(index + 1);
			}
			// 判断单个文件大于1M
			long fileSize = file.getSize();
			if (fileSize > 1024 * 1024) {
				System.out.println("文件大小为(单位字节):" + fileSize);
				System.out.println("该文件大于1M");
			}
			// 当文件有后缀名时
			if (fileName.indexOf(".") >= 0) {
				// split()中放正则表达式; 转义字符"\\."代表 "."
				String[] fileNameSplitArray = fileName.split("\\.");
				// 加上random戳,防止附件重名覆盖原文件
				fileName = fileNameSplitArray[0] + (int) (Math.random() * 100000) + "." + fileNameSplitArray[1];
			}
			// 当文件无后缀名时(如C盘下的hosts文件就没有后缀名)
			if (fileName.indexOf(".") < 0) {
				// 加上random戳,防止附件重名覆盖原文件
				fileName = fileName + (int) (Math.random() * 100000);
			}
			System.out.println("fileName:" + fileName);
			// 根据文件的全路径名字(含路径、后缀),new一个File对象dest
			File dest = new File(deposeFilesDir + fileName);
			// 如果pathAll路径不存在，则创建相关该路径涉及的文件夹;
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			try {
				// 将获取到的附件file,transferTo写入到指定的位置(即:创建dest时，指定的路径)
				file.transferTo(dest);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("文件的全路径名字(含路径、后缀)>>>>>>>" + deposeFilesDir + fileName);

		}
	}

	/**
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//得到要下载的文件名
		//String fileName = URLDecoder.decode(request.getParameter("diarycontent"), "utf-8");
		String fileName = "morepicS80208-2211391857";
		//fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
		//上传的文件都是保存在D:\fileupload\目录下的子目录当中
		String fileSaveRootPath = "E:\\AAAAA\\picture";
		System.out.println(URLDecoder.decode("morepicS80208-2211391857", "utf-8"));
		//通过文件名找出文件的所在目录
		//String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
		//String path = fileSaveRootPath;
		//得到要下载的文件
		File file = new File(fileSaveRootPath + "\\" + fileName);
		//如果文件不存在       morepicS80208-2211391857
		System.out.println(file.exists());
		if (file.exists()) {
			request.setAttribute("message", "您要下载的资源已被删除！！");
		}
		//处理文件名
		String realname = fileName.substring(fileName.indexOf("_") + 1);
		//设置响应头，控制浏览器下载该文件
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
		//读取要下载的文件，保存到文件输入流
		System.out.println(fileSaveRootPath + "\\" + fileName);
		FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName+".jpg");
		//创建输出流
		OutputStream out = response.getOutputStream();
		//创建缓冲区
		byte buffer[] = new byte[1024];
		int len = 0;
		//循环将输入流中的内容读取到缓冲区当中
		while ((len = in.read(buffer)) > 0) {
			//输出缓冲区的内容到浏览器，实现文件下载
			out.write(buffer, 0, len);
		}
		//关闭文件输入流
		in.close();
		//关闭输出流
		out.close();
	}

	/**
	 *
	 * @param multipartFile
	 * @return
	 */
	@RequestMapping(value = "/uploadImg")
	public AjaxJson uploadImg(@RequestParam("file") MultipartFile multipartFile, HttpServletResponse response) throws BusinessException {
		AjaxJson ajaxJson=new AjaxJson();
		if (multipartFile.isEmpty() || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
			throw new BusinessException(ResultEnum.IMG_NOT_EMPTY);
		}
		String contentType = multipartFile.getContentType();
		if (!contentType.contains("")) {
			throw new BusinessException(ResultEnum.IMG_FORMAT_ERROR);
		}
		String root_fileName = multipartFile.getOriginalFilename();
		logger.info("上传图片:name={},type={}", root_fileName, contentType);
		//获取路径
		logger.info("图片保存路径={}", path);
		String file_name = null;
		try {
			file_name = SaveFile.saveImg(multipartFile, path);
			if(!StringUtils.isEmpty(file_name)){
				ajaxJson.setSuccess(true);
				ajaxJson.setMsg("上传成功");
				ajaxJson.setObj(path+File.separator+file_name);
			}
			logger.info("返回值：{}",ajaxJson);
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8") ;
			return ajaxJson;
		} catch (IOException e) {
			try {
				throw new BusinessException(ResultEnum.SAVE_IMG_ERROE);
			} catch (BusinessException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}










}
