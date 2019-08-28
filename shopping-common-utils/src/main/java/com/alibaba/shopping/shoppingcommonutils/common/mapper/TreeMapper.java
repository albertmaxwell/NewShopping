package com.alibaba.shopping.shoppingcommonutils.common.mapper;

import com.alibaba.shopping.shoppingcommonutils.common.bean.DeptEmtity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 金海洋
 * @date 2019/8/27  -18:01
 */
public interface TreeMapper {

	/**
	 * 获取顶级树型节点
	 * @return
	 */
		List<DeptEmtity> getNodeTree();

	/**
	 * 获取下一级树形节点
 	 * @return
	 */
		List<DeptEmtity> getNextNodeTree(@Param("deptId") String deptId);

}
