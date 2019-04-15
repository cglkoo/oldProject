package com.hzitxx.spring.demo.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzitxx.spring.demo.dao.BaseDaoHibernate5;

public class BaseDaoHibernate5Impl<T, PK extends Serializable> implements BaseDaoHibernate5<T, PK>{
	@Autowired
	private SessionFactory sessionFactory;   //spring配置文件中注入的。
	
 
	private Transaction transaction = null;
	private Class<T> entityClass;
 
	@SuppressWarnings("unchecked")
	public BaseDaoHibernate5Impl() {
		this.entityClass = null;
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
			this.entityClass = (Class<T>) parameterizedType[0];
			
		}
	}

	
	@Override
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	
	@Override
	public Session getSession() {
		return this.sessionFactory.openSession();   //如果手动打开了session,也需要手动关闭；
	}
	 
	@Override
	public T load(PK id) {
		Session session = this.getSession();
		this.transaction = session.beginTransaction();
		T t = null;
		try{
			 t = session.load(entityClass, id);
		}catch(Exception ex){
			this.transaction.rollback();
			ex.printStackTrace();
		}
		
		this.transaction.commit();
		if(session !=null){
			session.close();
			session = null;
		}
		return t;
	}

	@Override
	public T get(PK id) {
		return this.getSession().get(entityClass, id);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public PK save(T entity) {
		return (PK)this.getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		this.getSession().update(entity);
	}

	@Override
	public void merge(T entity) {
		this.getSession().merge(entity);
	}

	@Override
	public void delete(T entity) {
		Session session = this.getSession();
		transaction = session.beginTransaction();
		try{
			session.delete(entity);
		}catch(Exception ex){
			this.transaction.rollback();
			ex.printStackTrace();
		}
		transaction.commit();
		if(session.isOpen()){
			session.close();
			session = null;
		}
	}

	@Override
	public void delete(PK id) {
		this.delete(this.load(id));  //先查询再删除
	}

	@Override
	public void delete(PK[] ids) {
		for(PK id : ids){
			this.delete(id);    //循环调用上面的方法；
		}
	}

	@Override
	public void delete(List<T> list) {
		if(list!=null&&!list.isEmpty()){
			for(T t : list){
				this.delete(t);
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllList() {
		Session session = this.getSession();
		List<T> list = session.createQuery("from "+entityClass.getName()+" as model ").list();
		if(session.isOpen()){
			session.close();
			session = null;
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getUniqueObjectByProperty(String propertyName, Object value) {
		Session session = this.getSession();
		this.transaction = session.beginTransaction();
		T t = null;
		try{
			t= (T) session.createQuery("from "+entityClass.getName()+" as model where model."+propertyName+" = ?").setParameter(0, value).uniqueResult();
		}catch(Exception ex){
			this.transaction.rollback();
			ex.printStackTrace();
		}
		this.transaction.commit();
		if(session !=null){
			session.close();
			session = null;
		}
		return t;
	}

 
	@Override
	public List<T> getList(String propertyName, Object value) {
		return  getSession().createQuery("from "+entityClass.getName()+" as model where model."+propertyName+" = ?").setParameter(0, value).list();
	}

	@Override
	public Long getCount() {
		return (Long)this.getSession().createQuery("select count(*) from "+entityClass.getName()).uniqueResult();
	}
	

}
