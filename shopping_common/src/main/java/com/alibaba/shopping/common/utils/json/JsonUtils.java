package com.alibaba.shopping.common.utils.json;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

/**
 * @author 金海洋
 * @date 2019/8/24  -8:34
 */
public class JsonUtils {

	public String toJSONString() {
		SerializeWriter out = new SerializeWriter();
		try {
			new JSONSerializer(out).write(this);
			return out.toString();
		} finally {
			out.close();
		}
	}
}
