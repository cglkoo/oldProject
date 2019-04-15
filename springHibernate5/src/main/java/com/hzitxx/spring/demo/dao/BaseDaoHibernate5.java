package com.hzitxx.spring.demo.dao;

import java.io.Serializable;

import java.util.List;

import org.hibernate.Session;
//接口
public interface BaseDaoHibernate5<T, PK extends Serializable> {
	
	public void setEntityClass(Class<T> entityClass);
	
	/**
	 * 获取hibernate session对象
	 * @return
	 */
	public Session getSession();
	 
	/**
	 * 通过id加载实体
	 * @param id
	 * @return 实体对象
	 */
	public T load(PK id);

	/**
	 * 通过id加载实体
	 * @param id
	 * @return 实体对象
	 */
	public T get(PK id);

	
	/**
	 * 保存实体对象.
	 * @param entity
	 * @return ID
	 */
	public PK save(T entity);
	
	/**
	 * 保存或更新一个对象
	 * @param entity
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 更新实体对象.
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 合并一个对象
	 * @param entity
	 */
	public void merge(T entity);

	/**
	 * 删除实体对象.
	 * @param entity
	 * @return
	 */
	public void delete(T entity);

	/**
	 * 根据ID删除实体对象.
	 * @param id
	 */
	public void delete(PK id);

	/**
	 * 根据ID数组删除实体对象.
	 * @param ids
	 */
	public void delete(PK[] ids);
	
	/**
	 * 根据实体集合删除实体对象
	 * @param list
	 */
	public void delete(List<T> list);
	
	/**
	 * 获取全部列表
	 * @return
	 */
	public List<T> getAllList();
	 
	/**
	 * 根据属性名和属性值获取实体对象.
	 * @param propertyName
	 * @param value
	 * @return 实体对象
	 */
	public T getUniqueObjectByProperty(String propertyName, Object value);
	/**
	 * 根据属性名和属性值获取实体对象集合.
	 * @param propertyName
	 * @param value
	 * @return 实体对象集合
	 */
	public List<T> getList(String propertyName, Object value);

	/**
	 * 获取所有实体对象总数.
	 * @return 实体对象总数
	 */
	public Long getCount();
	
	
}
