package com.shopping.shopping_protal_service.service;

import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author 金海洋
 * @date 2019/9/30  -14:12
 */
public interface CommonService {

	/**
	 *
	 * @return
	 *//*
	public Integer getAllDbTableSize();*/

	/**
	 * 保存实体
	 * @param entity
	 * @param <T>
	 * @return
	 */
	public <T> Serializable save(T entity);

	/**
	 * 更新实体
	 * @param entity
	 * @param <T>
	 */
	public <T> void saveOrUpdate(T entity);

	/**
	 * 删除一个实体
	 * @param entity
	 * @param <T>
	 */
	public <T> void delete(T entity);

	/**
	 *
	 * @param entitys
	 * @param <T>
	 */
	public <T> void batchSave(List<T> entitys);

	/**
	 * 根据实体名称和主键获取实体
	 * @param class1
	 * @param id
	 * @param <T>
	 * @return
	 */
	public <T> T get(Class<T> class1, Serializable id);

	/**
	 * 根据实体名称和主键获取实体
	 *
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 */
	public <T> T getEntity(Class entityName, Serializable id);

	/**
	 * 根据实体名称和字段名称和字段值获取唯一记录
	 *
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public <T> T findUniqueByProperty(Class<T> entityClass,
									  String propertyName, Object value);

	/**
	 * 按属性查找对象列表.
	 */
	public <T> List<T> findByProperty(Class<T> entityClass,
									  String propertyName, Object value);

	/**
	 * 加载全部实体
	 *
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> loadAll(final Class<T> entityClass);

	/**
	 * 删除实体主键删除
	 * @param entityName
	 * @param id
	 * @param <T>
	 */
	public <T> void deleteEntityById(Class entityName, Serializable id);

	/**
	 * 删除实体集合
	 *
	 * @param <T>
	 * @param entities
	 */
	public <T> void deleteAllEntitie(Collection<T> entities);

	/**
	 * 更新指定的实体
	 *
	 * @param <T>
	 * @param pojo
	 */
	public <T> void updateEntitie(T pojo);

	/**
	 * 通过hql 查询语句查找对象
	 * @param hql
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findByQueryString(String hql);

	/**
	 * 根据sql更新
	 * @param sql
	 * @return
	 */
	public int updateBySqlString(String sql);

	/**
	 * 根据sql查找List
	 *
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findListbySql(String query);

	/**
	 * 通过属性称获取实体带排序
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @param isAsc
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
											 String propertyName, Object value, boolean isAsc);

	public <T> List<T> getList(Class clas);

	public <T> T singleResult(String hql);


	public Session getSession();

/*
	public List findByExample(final String entityName,
							  final Object exampleEntity);
*/

	/**
	 * 执行SQL
	 * @param sql
	 * @param param
	 * @return
	 */
	public Integer executeSql(String sql, List<Object> param);

	/**
	 * 执行SQL
	 * @param sql
	 * @param param
	 * @return
	 */
	public Integer executeSql(String sql, Object... param);

	/**
	 * 执行SQL 使用:name占位符
	 * @param sql
	 * @param param
	 * @return
	 */
	public Integer executeSql(String sql, Map<String, Object> param);

	/**
	 * 执行SQL 使用:name占位符,并返回执行后的主键值
	 * @param sql
	 * @param param
	 * @return
	 *//*
	public Object executeSqlReturnKey(String sql, Map<String, Object> param);
*/
	/**
	 * 通过JDBC查找对象集合 使用指定的检索标准检索数据返回数据
	 * @param sql
	 * @param objs
	 * @return
	 */
	public List<Map<String, Object>> findForJdbc(String sql, Object... objs);

	/**
	 * 通过JDBC查找对象集合 使用指定的检索标准检索数据返回数据
	 * @param sql
	 * @param objs
	 * @return
	 */
	public Map<String, Object> findOneForJdbc(String sql, Object... objs);

	/**
	 * 通过JDBC查找对象集合,带分页 使用指定的检索标准检索数据并分页返回数据
	 * @param sql
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Map<String, Object>> findForJdbc(String sql, int page, int rows);

	/**
	 * 通过JDBC查找对象集合,带分页 使用指定的检索标准检索数据并分页返回数据
	 * @param sql
	 * @param page
	 * @param rows
	 * @param clazz
	 * @param <T>
	 * @return
	 *//*
	public <T> List<T> findObjForJdbc(String sql, int page, int rows,
									  Class<T> clazz);*/

	/**
	 * 使用指定的检索标准检索数据并分页返回数据-采用预处理方式
	 * @param sql
	 * @param page
	 * @param rows
	 * @param objs
	 * @return
	 *//*
	public List<Map<String, Object>> findForJdbcParam(String sql, int page,
													  int rows, Object... objs);*/

	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC
	 * @param sql
	 * @return
	 */
	public Long getCountForJdbc(String sql);

	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC-采用预处理方式
	 * @param sql
	 * @param objs
	 * @return
	 */
	public Long getCountForJdbcParam(String sql, Object... objs);

	/**
	 * 通过hql 查询语句查找对象
	 * @param hql
	 * @param param
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findHql(String hql, Object... param);

	public <T> T findOneHql(String hql,Object... param);

	public <T> List<T> pageList(DetachedCriteria dc, int firstResult,
								int maxResult);

/*
	public <T> List<T> findByDetached(DetachedCriteria dc);
*/

	/**
	 * 执行存储过程
	 * @param procedureSql
	 * @param params
	 * @param <T>
	 * @return
	 */
	public <T> List<T> executeProcedure(String procedureSql,Object... params);




}
