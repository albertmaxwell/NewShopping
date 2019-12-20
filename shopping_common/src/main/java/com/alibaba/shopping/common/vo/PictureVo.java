package com.alibaba.shopping.common.vo;

import lombok.Data;

/**
 * @author 金海洋
 * @date 2019/11/2  -9:32
 */
@Data
public class PictureVo {

	private String url;

	private String createDate;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
