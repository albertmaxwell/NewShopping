package com.alibaba.shopping.common.utils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 金海洋
 * @date 2019/8/17  -20:35
 */
public class StringUtil {

	/**
	 * 判断是否是空字符串 null和"" 都返回 true
	 *
	 * @param s
	 * @return
	 * @author Robin Chang
	 */
	public static boolean isEmpty(String s) {
		if (s != null && !s.equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * 获取实体类主键
	 *
	 * @param clazz 实体
	 * @return
	 */
	public static Field getIdField(Class clazz) {
		//访问该类的成员变量
		Field[] fields = clazz.getDeclaredFields();
		Field item = null;
		for (Field field : fields) {
			Id id = field.getAnnotation(Id.class);
			if (id != null) {
				//f.setAccessible(true);得作用就是让我们在用反射时访问私有变量
				field.setAccessible(true);
				item = field;
				break;
			}
		}
		if (item == null) {
			//并且访问父类变量
			Class<?> superclass = clazz.getSuperclass();
			if (superclass != null) {
				item = getIdField(superclass);
			}
		}
		return item;
	}



	/**
	 * 通过获取类上的@Table注解获取表名称
	 *
	 * @param entity 实体
	 * @return
	 */
	public static String getTableName(Object entity) {
		Class clazz = entity.getClass();
		String tableName = null;
		Annotation annotation = clazz.getAnnotation(Table.class);
		if (annotation != null) {
			//强制转化为相应的注释获取类上的表名称
			Table table = (Table) annotation;
			tableName = table.name();
		}
		return tableName;
	}


	/**
	 * 根据字段名找到对应属性
	 *
	 * @param entity 实体类
	 * @param field  表字段名
	 * @return
	 */
	public static String getPropertyByField(Object entity, String field) {
		Method[] methods = entity.getClass().getMethods();
		for (Method mt : methods) {
			Column mtAnnotation = mt.getAnnotation(Column.class);
			if (mtAnnotation != null) {
				String col = mtAnnotation.name();
				if (field.equalsIgnoreCase(col)) {
					String name = mt.getName();
					StringBuffer string = new StringBuffer();
					string.append(name.substring(3, 4).toLowerCase());
					string.append(name.substring(4));
					String property = string.toString();
					return property;
				}
			}
		}
		return null;
	}

	/**
	 * 根据属性名称获取实体类属性值
	 * 实例化这个对象并且保证这个对
	 * 象的指定的属性值有值
	 * @param clazz    实体类
	 * @param property 属性名称
	 * @return
	 */
	public static Object getValueByName(Object clazz, String property) {
		try {
			String firstLetter = property.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + property.substring(1);
			Method method = clazz.getClass().getMethod(getter, new Class[]{});
			Object value = method.invoke(clazz, new Object[]{});//属性值
			return value;
		} catch (Exception e) {
			return null;
		}
	}



}
