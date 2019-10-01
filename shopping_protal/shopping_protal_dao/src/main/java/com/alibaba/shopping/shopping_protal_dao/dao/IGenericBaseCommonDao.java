package com.alibaba.shopping.shopping_protal_dao.dao;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 
 * 类描述：DAO层泛型基类接口
 *  金海洋
 */

//@Repository需要在Spring中配置扫描地址，然后生成Dao层的Bean才能被注入到Service层中。
//@Mapper不需要配置扫描地址，通过xml里面的namespace里面的接口地址，生成了Bean后注入到Service层中

public interface IGenericBaseCommonDao {


	public <T> Serializable save(T entity);

	public <T> void batchSave(List<T> entitys);

	public <T> void saveOrUpdate(T entity);

	/**
	 * 删除实体
	 * 
	 * @param <T>*
	 * @param <T>*
	 * @param <T>
	 * @param entitie
	 */
	public <T> void delete(T entitie);

	/**
	 * 根据实体名称和主键获取实体
	 * 
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> entityName, Serializable id);

	/**
	 * 根据实体名字获取唯一记录
	 * 
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
	 * 根据实体名称和主键获取实体
	 *
	 * @param <T>
	 *
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 */
	public <T> T getEntity(Class entityName, Serializable id);

	/**
	 *
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
	 *
	 * @param entityName
	 * @param id
	 * @param <T>
	 */
	public <T> void updateEntityById(Class entityName, Serializable id);

	/**
	 * 通过hql 查询语句查找对象
	 * @param hql
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findByQueryString(String hql);

	/**
	 * 通过hql查询唯一对象
	 * @param hql
	 * @param <T>
	 * @return
	 */
	public <T> T singleResult(String hql);

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
	 *
	 * @param <T>
	 * @param clas
	 * @return
	 */
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
											 String propertyName, Object value, boolean isAsc);


	/**
	 *
	 * @return
	 */
	public Session getSession();




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
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC
	 */
	public Long getCountForJdbc(String sql);

	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC-采用预处理方式
	 *
	 */
	public Long getCountForJdbcParam(String sql, Object[] objs);

	/**
	 * 通过hql 查询语句查找对象
	 *
	 * @param <T>
	 * @param query
	 * @return
	 */
	public <T> List<T> findHql(String hql, Object... param);

	/**
	 *
	 * @param hql
	 * @param param
	 * @param <T>
	 * @return
	 */
	public <T> T findOneHql(String hql, Object... param);

	/**
	 * 执行HQL语句操作更新
	 *
	 * @param hql
	 * @return
	 */
	public Integer executeHql(String hql);

	/**
	 *
	 * @param dc
	 * @param firstResult
	 * @param maxResult
	 * @param <T>
	 * @return
	 */
	public <T> List<T> pageList(DetachedCriteria dc, int firstResult,
								int maxResult);



	/**
	 * 执行存储过程
	 * @param procedureSql
	 * @param params
	 * @param <T>
	 * @return
	 */
	public <T> List<T> executeProcedure(String procedureSql, Object... params);

}
