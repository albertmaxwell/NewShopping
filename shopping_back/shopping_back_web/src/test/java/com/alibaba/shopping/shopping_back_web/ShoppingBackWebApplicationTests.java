package com.alibaba.shopping.shopping_back_web;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingBackWebApplicationTests {

	@Value("${web.upload-path}")
	private String path;

	@Test
	public void contextLoads() {
	}

	/**
	 *
	 * @throws Exception
	 */
	@Test
	public void uploadTest() throws Exception {
		File f = new File("E:/AAAAA/picture/morepicS80208-2211391857.jpg");
		FileCopyUtils.copy(f, new File(path+"/1.jpg"));
	}

	/**
	 * 测试
	 */
	@Test
	public void listFilesTest() {
		File file = new File(path);
		for(File f : file.listFiles()) {
			System.out.println("fileName : "+f.getName());
		}
	}

	@Test
	public void testExportWord() throws Exception {
		String tmpFile = "D:/temp/a.docx";
		String expFile = "D:/temp/b.docx";
		Map<String, String> datas = new HashMap<String, String>();
		datas.put("title", "标题部份");
		datas.put("content", "这里是内容，测试使用POI导出到Word的内容！");
		datas.put("author", "知识林");
		datas.put("url", "http://www.zslin.com");

		build(new File(tmpFile), datas, expFile);
	}

	@Test
	public void testExportWord2() throws Exception {
		String tmpFile = "classpath:template.doc";
		String expFile = "D:/temp/result.doc";
		Map<String, String> datas = new HashMap<String, String>();
		datas.put("title", "标题部份");
		datas.put("content", "这里是内容，测试使用POI导出到Word的内容！");
		datas.put("author", "知识林");
		datas.put("url", "http://www.zslin.com");

		build(ResourceUtils.getFile(tmpFile), datas, expFile);
	}

	private void build(File tmpFile, Map<String, String> contentMap, String exportFile) throws Exception {
		FileInputStream tempFileInputStream = new FileInputStream(tmpFile);
		HWPFDocument document = new HWPFDocument(tempFileInputStream);
		// 读取文本内容
		Range bodyRange = document.getRange();
		// 替换内容
		for (Map.Entry<String, String> entry : contentMap.entrySet()) {
			bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
		}

		//导出到文件
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		document.write(byteArrayOutputStream);
		OutputStream outputStream = new FileOutputStream(exportFile);
		outputStream.write(byteArrayOutputStream.toByteArray());
		outputStream.close();
	}

}
