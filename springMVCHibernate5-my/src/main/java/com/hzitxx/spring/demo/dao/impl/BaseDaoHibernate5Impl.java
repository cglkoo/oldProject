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
import com.hzitxx.spring.demo.model.Page;

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
		T t = null;
		try{
			 t = session.load(entityClass, id);
		}catch(Exception ex){
			this.transaction.rollback();
			ex.printStackTrace();
		}
		if(session !=null){
			session.close();
			session = null;
		}
		return t;
	}

	@Override
	public T get(PK id) {
		Session session=this.getSession();
		T t=null;
		try{
			t=session.get(entityClass, id);
		}catch(Exception ex){
			this.transaction.rollback();
			ex.printStackTrace();
		}
		if(session.isOpen()){
			session.close();
			session = null;
		}
		return t;
	}
	
	@Override
	public void save(T entity) {
		Session session=this.getSession();
		transaction = session.beginTransaction();
		try{
			session.save(entity);
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
	public void saveOrUpdate(T entity) {
		Session session=this.getSession();
		transaction = session.beginTransaction();
		try{
			session.saveOrUpdate(entity);
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
	public void update(T entity) {
		Session session = this.getSession();
		transaction = session.beginTransaction();
		try{
			session.update(entity);
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
	public void merge(T entity) {
		Session session = this.getSession();
		transaction = session.beginTransaction();
		try{
			session.merge(entity);
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
	public T getUniqueObjectByProperty(String propertyName, Object value) {  //根据字段的关键字查询唯一对象
		Session session = this.getSession();
		T t = null;
		try{
			t= (T) session.createQuery("from "+entityClass.getName()+" as model where model."+propertyName+" = ?").setParameter(0, value).uniqueResult();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if(session !=null){
			session.close();
			session = null;
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(String propertyName, Object value, Page page,String orderBy) {
		Session session = this.getSession();
		List<T> list =session.createQuery("from "+entityClass.getName()+" as model  where"
				+ " model."+propertyName+"  like  ? "
						+ " order by model."+orderBy+" desc ").setParameter(0, "%"+value+""
								+ "%").setFirstResult((int)page.getPosition()).setMaxResults((int)page.getPageSize()).list();
		if(session !=null){
			session.close();
			session = null;
		}
		return list;
	}

	@Override
	public Long getCount(String propertyName, String value) {  //模糊查询获得记录数
		Long count = 0l;
		Session session = this.getSession();   
		count = (Long)session.createQuery("select count(1) from "+entityClass.getName() +" as model where model."+propertyName+" like ?").setParameter(0, "%"+value+"%").uniqueResult();
		if(session !=null){
			session.close();
			session = null;
		}
		System.out.println(count);
		return count;
		
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
	public List<T> getAllList(String propertyName, Object value) {
		Session session = this.getSession();
		List<T>  list =  session.createQuery("from "+entityClass.getName()+" as model where model."+propertyName+" = ?").setParameter(0, value).list();
		if(session !=null){
			session.close();
			session = null;
		}
		return list;
	}
	
	

}
