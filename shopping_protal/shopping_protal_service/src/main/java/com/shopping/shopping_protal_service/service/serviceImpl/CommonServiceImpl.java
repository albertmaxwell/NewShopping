package com.shopping.shopping_protal_service.service.serviceImpl;

import com.alibaba.shopping.shopping_protal_dao.dao.ICommonDao;
import com.alibaba.shopping.shopping_protal_dao.dao.IGenericBaseCommonDao;
import com.shopping.shopping_protal_service.service.CommonService;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *  金海洋
 */
@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {

	@Autowired
	public ICommonDao commonDao ;

	/*@Override
	@Transactional(readOnly = true)
	public Integer getAllDbTableSize() {

		return commonDao.getAllDbTableSize();
	}*/

	/*@Resource
	public void setCommonDao(ICommonDao commonDao) {
		this.commonDao = commonDao;
	}*/


	@Override
	public <T> Serializable save(T entity) {
		return commonDao.save(entity);
	}


	/**
	 *
	 * @param entity
	 * @param <T>
	 */
	@Override
	public <T> void saveOrUpdate(T entity) {
		commonDao.saveOrUpdate(entity);

	}

	/**
	 *
	 * @param entity
	 * @param <T>
	 */
	@Override
	public <T> void delete(T entity) {
		commonDao.delete(entity);

	}

	/**
	 * 删除实体集合
	 * 
	 * @param <T>
	 * @param entities
	 */
	@Override
	public <T> void deleteAllEntitie(Collection<T> entities) {
		commonDao.deleteAllEntitie(entities);
	}

	/**
	 * 根据实体名获取对象
	 */
	@Override
	@Transactional(readOnly = true)
	public <T> T get(Class<T> class1, Serializable id) {
		return commonDao.get(class1, id);
	}

	/**
	 * 根据实体名返回全部对象
	 * @param clas
	 * @param <T>
	 * @return
	 */
    @Override
	@Transactional(readOnly = true)
	public <T> List<T> getList(Class clas) {
		return commonDao.loadAll(clas);
	}

	/**
	 * 根据实体名获取对象
	 */
    @Override
	@Transactional(readOnly = true)
	public <T> T getEntity(Class entityName, Serializable id) {
		return commonDao.getEntity(entityName, id);
	}

	/**
	 * 根据实体名称和字段名称和字段值获取唯一记录
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return
	 */
    @Override
	@Transactional(readOnly = true)
	public <T> T findUniqueByProperty(Class<T> entityClass,
			String propertyName, Object value) {
		return commonDao.findUniqueByProperty(entityClass, propertyName, value);
	}

	/**
	 * 按属性查找对象列表.
	 */
    @Override
	@Transactional(readOnly = true)
	public <T> List<T> findByProperty(Class<T> entityClass,
			String propertyName, Object value) {

		return commonDao.findByProperty(entityClass, propertyName, value);
	}

	/**
	 * 加载全部实体
	 * 
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
    @Override
	@Transactional(readOnly = true)
	public <T> List<T> loadAll(final Class<T> entityClass) {
		return commonDao.loadAll(entityClass);
	}

	/**
	 *
	 * @param hql
	 * @param <T>
	 * @return
	 */
    @Override
	@Transactional(readOnly = true)
	public <T> T singleResult(String hql) {
		return commonDao.singleResult(hql);
	}


	/**
	 *
	 * @param entityName
	 * @param id
	 * @param <T>
	 */
	@Override
	public <T> void deleteEntityById(Class entityName, Serializable id) {
		commonDao.deleteEntityById(entityName, id);
	}

	/**
	 * 更新指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 */
	@Override
	public <T> void updateEntitie(T pojo) {
		commonDao.updateEntitie(pojo);

	}

	/**
	 * 通过hql 查询语句查找对象
	 * @param hql
	 * @param <T>
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public <T> List<T> findByQueryString(String hql) {
		return commonDao.findByQueryString(hql);
	}

	/**
	 * 根据sql更新
	 * @param sql
	 * @return
	 */
	@Override
	public int updateBySqlString(String sql) {
		return commonDao.updateBySqlString(sql);
	}

	/**
	 * 根据sql查找List
	 * 
	 * @param <T>
	 * @param query
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public <T> List<T> findListbySql(String query) {
		return commonDao.findListbySql(query);
	}

	/**
	 * 通过属性称获取实体带排序
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @param isAsc
	 * @param <T>
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
			String propertyName, Object value, boolean isAsc) {
		return commonDao.findByPropertyisOrder(entityClass, propertyName,
				value, isAsc);
	}


	/**
	 *
	 * @return
	 */
	@Override
	public Session getSession() {
		return commonDao.getSession();
	}

	/**
	 *
	 * @param entityName
	 * @param exampleEntity
	 * @return
	 *//*
	@Override
	@Transactional(readOnly = true)
	public List findByExample(final String entityName, final Object exampleEntity) {
		return commonDao.findByExample(entityName, exampleEntity);
	}*/


	/**
	 *
	 * @param sql
	 * @param param
	 * @return
	 */
	@Override
	public Integer executeSql(String sql, List<Object> param) {
		return commonDao.executeSql(sql, param);
	}

	/**
	 *
	 * @param sql
	 * @param param
	 * @return
	 */
	@Override
	public Integer executeSql(String sql, Object... param) {
		return commonDao.executeSql(sql, param);
	}

	/**
	 *
	 * @param sql
	 * @param param
	 * @return
	 */
	@Override
	public Integer executeSql(String sql, Map<String, Object> param) {
		return commonDao.executeSql(sql, param);
	}

	/**
	 *
	 * @param sql
	 * @param param
	 * @return
	 *//*
	@Override
	public Object executeSqlReturnKey(String sql, Map<String, Object> param) {
		return commonDao.executeSqlReturnKey(sql, param);
	}*/

	/**
	 *
	 * @param sql
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findForJdbc(String sql, int page, int rows) {
		return commonDao.findForJdbc(sql, page, rows);
	}

	/**
	 *
	 * @param sql
	 * @param objs
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
		return commonDao.findForJdbc(sql, objs);
	}

	/**
	 *
	 * @param sql
	 * @param page
	 * @param rows
	 * @param objs
	 * @return
	 *//*
	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findForJdbcParam(String sql, int page,
			int rows, Object... objs) {
		return commonDao.findForJdbcParam(sql, page, rows, objs);
	}*/

	/**
	 *
	 * @param sql
	 * @param page
	 * @param rows
	 * @param clazz
	 * @param <T>
	 * @return
	 *//*
	@Override
	@Transactional(readOnly = true)
	public <T> List<T> findObjForJdbc(String sql, int page, int rows,
			Class<T> clazz) {
		return commonDao.findObjForJdbc(sql, page, rows, clazz);
	}*/

	/**
	 *
	 * @param sql
	 * @param objs
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> findOneForJdbc(String sql, Object... objs) {
		return commonDao.findOneForJdbc(sql, objs);
	}

	/**
	 *
	 * @param sql
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public Long getCountForJdbc(String sql) {
		return commonDao.getCountForJdbc(sql);
	}

	/**
	 *
	 * @param sql
	 * @param objs
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public Long getCountForJdbcParam(String sql, Object... objs) {
		return commonDao.getCountForJdbcParam(sql,objs);
	}

	/**
	 *
	 * @param entitys
	 * @param <T>
	 */
	@Override
	public <T> void batchSave(List<T> entitys) {
		this.commonDao.batchSave(entitys);
	}

	/**
	 * 通过hql 查询语句查找对象
	 * @param hql
	 * @param param
	 * @param <T>
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public <T> List<T> findHql(String hql, Object... param) {
		return this.commonDao.findHql(hql, param);
	}

	@Override
	public <T> T findOneHql(String hql, Object... param) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public <T> List<T> pageList(DetachedCriteria dc, int firstResult,
								int maxResult) {
		return this.commonDao.pageList(dc, firstResult, maxResult);
	}

	/*@Override
	@Transactional(readOnly = true)
	public <T> List<T> findByDetached(DetachedCriteria dc) {
		return this.commonDao.findByDetached(dc);
	}*/

	/**
	 * 调用存储过程
	 */
	@Override
	public <T> List<T> executeProcedure(String procedureSql, Object... params) {
		return this.commonDao.executeProcedure(procedureSql, params);
	}


}
