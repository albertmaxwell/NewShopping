package com.shopping.shopping_protal_service.service.serviceImpl;

import com.alibaba.shopping.shopping_bean.bean.GoodsBrand;
import com.alibaba.shopping.shopping_bean.bean.GoodsClass;
import com.shopping.shopping_protal_service.service.IndexService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/9/29  -14:36
 */
@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService {


	@Override
	public List<GoodsClass> getGoodsClassList(Map<String, Object> map) throws Exception {
		return null;
	}

	@Override
	public List<GoodsBrand> getGoodsBrandList(Map<String, Object> map) throws Exception {
		return null;
	}
}
