package com.alibaba.shopping.shoppingcommonutils.common.service.impl;

import com.alibaba.shopping.shoppingcommonutils.common.bean.DeptEmtity;
import com.alibaba.shopping.shoppingcommonutils.common.mapper.TreeMapper;
import com.alibaba.shopping.shoppingcommonutils.common.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 金海洋
 * @date 2019/8/27  -17:57
 */
@Service("tree")
@Transactional
public class TreeServiceImpl  implements TreeService {

	@Autowired
	private TreeMapper treeMapper;


	@Override
	public List<DeptEmtity> getNoteTree() {

		List<DeptEmtity> deptEmtityList=treeMapper.getNodeTree();
		return deptEmtityList;
	}
}
