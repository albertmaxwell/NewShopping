package com.alibaba.shopping.shopping_protal_dao.dao;

import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 *
 * 类描述： DAO层泛型基类
 *
 */
@Repository("commonDao")
public abstract class GenericBaseCommonDao<T, PK extends Serializable>
		implements IGenericBaseCommonDao {

	/**
	 * 注入一个sessionFactory属性,并注入到父类(HibernateDaoSupport)
	 * **/
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 获得该类的属性和类型
	 *
	 * @param entityName
	 *            注解的实体类
	 */
	private <T> void getProperty(Class entityName) {
		ClassMetadata cm = sessionFactory.getClassMetadata(entityName);
		String[] str = cm.getPropertyNames(); // 获得该类所有的属性名称
		for (int i = 0; i < str.length; i++) {
			String property = str[i];
			String type = cm.getPropertyType(property).getName(); // 获得该名称的类型
		}
	}


	/**
	 * 根据实体名字获取唯一记录
	 *
	 * @param propertyName
	 * @param value
	 * @return
	 */
	@Override
	public <T> T findUniqueByProperty(Class<T> entityClass,
									  String propertyName, Object value) {
		Assert.hasText(propertyName);
		return (T) createCriteria(entityClass,
				Restrictions.eq(propertyName, value)).uniqueResult();
	}

	/**
	 * 按属性查找对象列表.
	 */
	@Override
	public <T> List<T> findByProperty(Class<T> entityClass,
									  String propertyName, Object value) {
		Assert.hasText(propertyName);
		return (List<T>) createCriteria(entityClass,
				Restrictions.eq(propertyName, value)).list();
	}

	/**
	 * 根据传入的实体持久化对象
	 */
	@Override
	public <T> Serializable save(T entity) {
		try {
			Serializable id = getSession().save(entity);
			return id;
		} catch (RuntimeException e) {
			throw e;
		}

	}

	/**
	 * 批量保存数据
	 *
	 * @param <T>
	 * @param entitys
	 *            要持久化的临时实体对象集合
	 */
	@Override
	public <T> void batchSave(List<T> entitys) {
		for (int i = 0; i < entitys.size(); i++) {
			getSession().save(entitys.get(i));
			if (i % 1000 == 0) {
				// 1000个对象批量写入数据库，后才清理缓存
				getSession().flush();
				getSession().clear();
			}
		}
		//最后页面的数据，进行提交手工清理
		getSession().flush();
		getSession().clear();
	}

	/**
	 * 根据传入的实体添加或更新对象
	 * @param <T>*
	 * @param entity
	 */

	@Override
	public <T> void saveOrUpdate(T entity) {
		try {
			getSession().saveOrUpdate(entity);

		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * 根据传入的实体删除对象
	 */
	@Override
	public <T> void delete(T entity) {
		try {
			getSession().delete(entity);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	/**
	 * 根据主键删除指定的实体
	 *
	 * @param <T>
	 * @param pojo
	 */
	@Override
	public <T> void deleteEntityById(Class entityName, Serializable id) {
		delete(get(entityName, id));
	}

	/**
	 * 删除全部的实体
	 *
	 * @param <T>
	 *
	 * @param entitys
	 */
	@Override
	public <T> void deleteAllEntitie(Collection<T> entitys) {
		for (Object entity : entitys) {
			getSession().delete(entity);
		}
	}

	/**
	 * 根据Id获取对象。
	 */
	@Override
	public <T> T get(Class<T> entityClass, final Serializable id) {

		return (T) getSession().get(entityClass, id);

	}

	/**
	 * 根据主键获取实体并加锁。
	 *
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @param lock
	 * @return
	 */
	@Override
	public <T> T getEntity(Class entityName, Serializable id) {

		T t = (T) getSession().get(entityName, id);
		if (t != null) {
			//getSession().flush();
		}
		return t;
	}

	/**
	 * 更新指定的实体
	 *
	 * @param <T>
	 * @param pojo
	 */
	@Override
	public <T> void updateEntitie(T pojo) {
		getSession().update(pojo);
		//getSession().flush();
	}

	/**
	 * 更新指定的实体
	 *
	 * @param <T>
	 * @param pojo
	 */
	public <T> void updateEntitie(String className, Object id) {
		getSession().update(className, id);
		//getSession().flush();
	}

	/**
	 * 根据主键更新实体
	 */
	@Override
	public <T> void updateEntityById(Class entityName, Serializable id) {
		updateEntitie(get(entityName, id));
	}

	/**
	 * 通过hql 查询语句查找对象
	 *
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Override
	public List<T> findByQueryString(final String query) {

		Query queryObject = getSession().createQuery(query);
		List<T> list = queryObject.list();
//		if (list.size() > 0) {
			//getSession().flush();
//		}
		return list;

	}

	/**
	 * 通过hql查询唯一对象
	 *
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Override
	public <T> T singleResult(String hql) {
		T t = null;
		Query queryObject = getSession().createQuery(hql);
		List<T> list = queryObject.list();
		if (list.size() == 1) {
			t = list.get(0);
		} else if (list.size() > 0) {
		}
		return t;
	}

	/**
	 * 通过hql 查询语句查找HashMap对象
	 *
	 * @param <T>
	 * @param query
	 * @return
	 */
	public Map<Object, Object> getHashMapbyQuery(String hql) {

		Query query = getSession().createQuery(hql);
		List list = query.list();
		Map<Object, Object> map = new HashMap<Object, Object>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] tm = (Object[]) iterator.next();
			map.put(tm[0].toString(), tm[1].toString());
		}
		return map;

	}

	/**
	 * 通过sql更新记录
	 *
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Override
	public int updateBySqlString(final String query) {

		Query querys = getSession().createSQLQuery(query);
		return querys.executeUpdate();
	}

	/**
	 * 通过sql查询语句查找对象
	 *
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Override
	public List<T> findListbySql(final String sql) {
		Query querys = getSession().createSQLQuery(sql);
		return querys.list();
	}

	/**
	 * 创建Criteria对象，有排序功能。
	 *
	 * @param <T>
	 * @param entityClass
	 * @param orderBy
	 * @param isAsc
	 * @param criterions
	 * @return
	 */
	private <T> Criteria createCriteria(Class<T> entityClass, boolean isAsc,
										Criterion... criterions) {
		Criteria criteria = createCriteria(entityClass, criterions);
		if (isAsc) {
			criteria.addOrder(Order.asc("asc"));
		} else {
			criteria.addOrder(Order.desc("desc"));
		}
		return criteria;
	}

	/**
	 * 创建Criteria对象带属性比较
	 *
	 * @param <T>
	 * @param entityClass
	 * @param criterions
	 * @return
	 */
	private <T> Criteria createCriteria(Class<T> entityClass,
										Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	@Override
	public <T> List<T> loadAll(final Class<T> entityClass) {
		Criteria criteria = createCriteria(entityClass);
		return criteria.list();
	}

	/**
	 * 创建单一Criteria对象
	 *
	 * @param <T>
	 * @param entityClass
	 * @param criterions
	 * @return
	 */
	private <T> Criteria createCriteria(Class<T> entityClass) {
		Criteria criteria = getSession().createCriteria(entityClass);
		return criteria;
	}

	/**
	 * 根据属性名和属性值查询. 有排序
	 *
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @param orderBy
	 * @param isAsc
	 * @return
	 */
	@Override
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
											 String propertyName, Object value, boolean isAsc) {
		Assert.hasText(propertyName);
		return createCriteria(entityClass, isAsc,
				Restrictions.eq(propertyName, value)).list();
	}

	/**
	 * 根据属性名和属性值 查询 且要求对象唯一.
	 *
	 * @return 符合条件的唯一对象.
	 */
	public <T> T findUniqueBy(Class<T> entityClass, String propertyName,
			Object value) {
		Assert.hasText(propertyName);
		return (T) createCriteria(entityClass,
				Restrictions.eq(propertyName, value)).uniqueResult();
	}

	/**
	 * 根据查询条件与参数列表创建Query对象
	 *
	 * @param session
	 *            Hibernate会话
	 * @param hql
	 *            HQL语句
	 * @param objects
	 *            参数列表
	 * @return Query对象
	 */
	public Query createQuery(Session session, String hql, Object... objects) {
		Query query = session.createQuery(hql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
		}
		return query;
	}

	/**
	 * 批量插入实体
	 *
	 * @param clas
	 * @param values
	 * @return
	 */
	public <T> int batchInsertsEntitie(List<T> entityList) {
		int num = 0;
		for (int i = 0; i < entityList.size(); i++) {
			save(entityList.get(i));
			num++;
		}
		return num;
	}

	/**
	 * 根据实体名返回全部对象
	 *
	 * @param <T>
	 * @param hql
	 * @param size
	 * @return
	 */
	/**
	 * 使用占位符的方式填充值 请注意：like对应的值格式："%"+username+"%" Hibernate Query
	 *
	 * @param hibernateTemplate
	 * @param hql
	 * @param valus
	 *            占位符号?对应的值，顺序必须一一对应 可以为空对象数组，但是不能为null
	 * @return
	 */
	public List<T> executeQuery(final String hql, final Object[] values) {
		Query query = getSession().createQuery(hql);
		// query.setCacheable(true);
		for (int i = 0; values != null && i < values.length; i++) {
			query.setParameter(i, values[i]);
		}

		return query.list();

	}


	/**
	 * 调用存储过程
	 */
	public void callableStatementByName(String proc) {
	}

	/**
	 * 查询指定实体的总记录数
	 *
	 * @param clazz
	 * @return
	 */
	public int getCount(Class<T> clazz) {

		int count = DataAccessUtils.intResult(getSession().createQuery(
				"select count(*) from " + clazz.getName()).list());
		return count;
	}


	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC
	 */
	@Override
	public Long getCountForJdbc(String sql) {
		return this.jdbcTemplate.queryForObject(sql,Long.class);
	}

	/**
	 * 使用指定的检索标准检索数据并分页返回数据For JDBC-采用预处理方式
	 *
	 */
	@Override
	public Long getCountForJdbcParam(String sql, Object[] objs) {

		return this.jdbcTemplate.queryForObject(sql, objs,Long.class);


	}

	@Override
	public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
		return this.jdbcTemplate.queryForList(sql, objs);
	}

	@Override
	public Integer executeSql(String sql, List<Object> param) {
		return this.jdbcTemplate.update(sql, param);
	}

	@Override
	public Integer executeSql(String sql, Object... param) {
		return this.jdbcTemplate.update(sql, param);
	}

	@Override
	public Integer executeSql(String sql, Map<String, Object> param) {
		return this.namedParameterJdbcTemplate.update(sql, param);
	}


	public Integer countByJdbc(String sql, Object... param) {

		return this.jdbcTemplate.queryForObject(sql, param,Integer.class);


	}

	@Override
	public Map<String, Object> findOneForJdbc(String sql, Object... objs) {
		try {
			return this.jdbcTemplate.queryForMap(sql, objs);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/**
	 * 通过hql 查询语句查找对象
	 *
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Override
	public <T> List<T> findHql(String hql, Object... param) {
		Query q = getSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	@Override
	public <T> T findOneHql(String hql, Object... param) {
		List<T> tt = this.findHql(hql,param);
		if(tt==null){
			return null;
		}else{
			return tt.get(0);
		}
	}

	/**
	 * 执行HQL语句操作更新
	 *
	 * @param hql
	 * @return
	 */
	@Override
	public Integer executeHql(String hql) {
		Query q = getSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public <T> List<T> pageList(DetachedCriteria dc, int firstResult,
								int maxResult) {
		Criteria criteria = dc.getExecutableCriteria(getSession());
		criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		criteria.setFirstResult(firstResult);
		criteria.setMaxResults(maxResult);
		return criteria.list();
	}


	/**
	 * 调用存储过程
	 */
	@Override
	public <T> List<T> executeProcedure(String executeSql, Object... params) {
		SQLQuery sqlQuery = getSession().createSQLQuery(executeSql);
		
		for(int i=0;i<params.length;i++){
			sqlQuery.setParameter(i, params[i]);
		}
		return sqlQuery.list();
	}

}
