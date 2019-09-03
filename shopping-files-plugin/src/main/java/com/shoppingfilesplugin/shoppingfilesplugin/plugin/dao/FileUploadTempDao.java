package com.shoppingfilesplugin.shoppingfilesplugin.plugin.dao;

import com.shoppingfilesplugin.shoppingfilesplugin.plugin.runner.FilePluginConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FileUploadTempDao {

	private Logger logger = LoggerFactory.getLogger(FileUploadTempDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 保存文件临时记录
	 * @param id
	 * @param url
	 * @param path
	 * @return
	 */
	public boolean saveFileUploadTemp(String id, String url, String path) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into " + FilePluginConfig.getInstance().getTableName()
				+ "(id, url, path, create_time) values(?,?,?,now())");
		int result = jdbcTemplate.update(sql.toString(), new Object[]{id, url==null?"null":url, path});
		if(result > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 删除临时文件信息
	 * @param id
	 */
	public void deleteById(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from " + FilePluginConfig.getInstance().getTableName() + " where id=?");
		jdbcTemplate.update(sql.toString(), id);
	}
	
	/**
	 * 查询所有临时表数据
	 * @return
	 */
	public List<Map<String, Object>> findAll() {
		return jdbcTemplate.queryForList("select * from " + FilePluginConfig.getInstance().getTableName());
	}
	
	/**
	 * 创建表
	 * @return
	 */
	public void createFileUploadTemp() {
		try {
			Map<String, Object> map = jdbcTemplate.queryForMap(
					"SELECT count(1) num FROM information_schema.TABLES where TABLE_NAME='"
							+ FilePluginConfig.getInstance().getTableName() + "'");
			if(map != null && map.size() > 0) {
				if(!map.get("num").toString().equals("0")) {
					logger.error("table " + FilePluginConfig.getInstance().getTableName() + " exists!");
					return;
				}
			}
		} catch (Exception e) {}
		
		StringBuffer sql = new StringBuffer();
		sql.append("CREATE TABLE `" + FilePluginConfig.getInstance().getTableName() + "` (");
		sql.append("`id`  varchar(36) NOT NULL ,");
		sql.append("`url`  varchar(255) NOT NULL COMMENT 'URL' ,");
		sql.append("`path`  varchar(255) NOT NULL COMMENT '本地磁盘路径' ,");
		sql.append("`create_time`  datetime NOT NULL COMMENT '创建时间' ,");
		sql.append("PRIMARY KEY (`id`)");
		sql.append(")COMMENT='文件信息临时存储';");
		
		jdbcTemplate.execute(sql.toString());
		logger.error("table " + FilePluginConfig.getInstance().getTableName() + " create!");
	}
}
