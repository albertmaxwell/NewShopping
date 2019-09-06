package com.alibaba.shopping.shoppingcommonutils.common.controller;

import com.alibaba.shopping.shoppingcommonutils.common.bean.DeptEmtity;
import com.alibaba.shopping.shoppingcommonutils.common.bean.ExcelData;

import com.alibaba.shopping.shoppingcommonutils.common.constant.ExcelConstant;
import com.alibaba.shopping.shoppingcommonutils.common.service.TreeService;
import com.alibaba.shopping.shoppingcommonutils.common.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 金海洋
 * @date 2019/9/6  -12:35
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

	@Autowired
	TreeService tree;

	@RequestMapping("/test")
	public Integer test(){
		int rowIndex = 0;
		List<DeptEmtity> deptEmtityList=tree.getNoteTree();
		ExcelData data = new ExcelData();
		data.setName("hello");
		List<String> titles = new ArrayList();
		titles.add("ID");
		titles.add("userName");
		titles.add("password");
		data.setTitles(titles);

		List<List<Object>> rows = new ArrayList();
		for(int i = 0, length = deptEmtityList.size();i<length;i++){
			DeptEmtity userInfo = deptEmtityList.get(i);
			List<Object> row = new ArrayList();
			row.add(userInfo.getName());
			row.add(userInfo.getDeptId());
			rows.add(row);
		}
		data.setRows(rows);
		try{
			rowIndex = ExcelUtils.generateExcel(data, ExcelConstant.FILE_PATH + ExcelConstant.FILE_NAME);
		}catch (Exception e){
			e.printStackTrace();
		}
		return Integer.valueOf(rowIndex);
	}

	@RequestMapping("/test2")
	public void test2(HttpServletResponse response){
		int rowIndex = 0;
		List<DeptEmtity> deptEmtityList=tree.getNoteTree();
		ExcelData data = new ExcelData();
		data.setName("hello");
		List<String> titles = new ArrayList();
		titles.add("ID");
		titles.add("userName");
		titles.add("password");
		data.setTitles(titles);

		List<List<Object>> rows = new ArrayList();
		for(int i = 0, length = deptEmtityList.size();i<length;i++){
			DeptEmtity userInfo = deptEmtityList.get(i);
			List<Object> row = new ArrayList();
			row.add(userInfo.getDeptId());
			row.add(userInfo.getName());
			rows.add(row);
		}
		data.setRows(rows);
		try{
			ExcelUtils.exportExcel(response,"test2",data);
		}catch (Exception e){
			e.printStackTrace();
		}
	}



}
