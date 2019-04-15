package com.hzitxx.spring.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.hzitxx.spring.demo.model.Page;
//接口
public interface BaseDaoHibernate5<T, PK extends Serializable> {
	
	public void setEntityClass(Class<T> entityClass);
	
	public Session getSession(); //获取hibernate session对象
	public T load(PK id);        //通过id加载实体
	public T get(PK id);         //通过id获得实体对象
	public void save(T entity);  //传入一个实体对象并且保存
	public void saveOrUpdate(T entity);  //保存或更新一个实体对象
	public void update(T entity);  //更新一个实体对象
	public void merge(T entity);   //合并一个实体对象
	public void delete(T entity);  //删除一个实体对象
	public void delete(PK id);     //根据ID删除实体对象.
	public void delete(PK[] ids);  //根据ID数组删除实体对象.
	public void delete(List<T> list);  //根据实体集合删除实体对象
	public T getUniqueObjectByProperty(String propertyName,Object value); //根据属性名和属性值获取实体对象.
	public List<T> getList(String propertyName, Object value,Page page,String orderBy);  //根据属性名和属性值获取实体对象集合.
	public Long getCount(String propertyName, String value);  //模糊查询获取记录数
	public List<T> getAllList();
	public List<T> getAllList(String propertyName, Object value);

	
	
}
