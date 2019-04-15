package com.hzitxx.demo.spring.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.SweetCake;

public class SpringTest {
	
	ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
	//下面开始我们的数据库操作
	Session session = sessionFactory.openSession();//从会话工厂获取一个session
	 
	//增加；
	public void addCake(SweetCake cake){
		Transaction transaction = session.beginTransaction();//开启一个新的事务
	    session.save(cake);
	    transaction.commit();        //提交事务
	    session.close();
	    System.out.println(cake);
	}
	

	//删除；
	public void deleteCake(Integer Id){
		Transaction transaction = session.beginTransaction();//开启一个新的事务
		SweetCake cake = session.get(SweetCake.class,Id);  //如果查询不到，报异常No Row...
	    session.delete(cake);
	    transaction.commit();        //提交事务
	    session.close();
	    System.out.println(cake);
	}
	
	//修改；
	public void updateCake(Integer Id){
		Transaction transaction = session.beginTransaction();//开启一个新的事务
		SweetCake cake = session.get(SweetCake.class,Id);   //如果是get方法查询不到，返回Null;
	    cake.setCakeBrand("林兵");
	    cake.setCakeName("西瓜味道的");
	    cake.setCakeNum(100);
	    cake.setId(19);
		session.update(cake);         //就是更新；
	    transaction.commit();        //提交事务
	    System.out.println(cake);
	    session.close();
	}
 
	//修改2；
	public void update2Cake(){
		Transaction transaction = session.beginTransaction();//开启一个新的事务
		SweetCake cake = new SweetCake();
	    cake.setCakeBrand("林兵110");
	    cake.setCakeName("凌檬味道的110");
	    cake.setCakeNum(100);
	    //cake.setId(11);//如果设置了ID并且该ID存在，则为更新；如果不设置ID为新增；如果设置的ID不存在，则报错！
		session.saveOrUpdate(cake);   //saveOrUpdate=save() or : update()；
	    transaction.commit();        //提交事务
	    System.out.println(cake);
	    session.close();
	}
	
	//修改3；
	public void update3Cake(){
		Transaction transaction = session.beginTransaction();//开启一个新的事务
		SweetCake cake = new SweetCake();
	    cake.setCakeBrand("林兵3");
	    cake.setCakeName("西瓜味道的3");
	    cake.setCakeNum(300);
		session.merge(cake);         //相当于saveOrUpdate方法，但是没有拿到ID;
	    transaction.commit();        //提交事务
	    System.out.println(cake);
	    session.close();
	}
	
	//查询一行数据：
	public SweetCake getSweetCakeById(int id){
		SweetCake ck = session.load(SweetCake.class, id);
		session.close();
		return ck;
	}
	
	//查询：
	public List<SweetCake> getAllSweetCakes(){
		List<SweetCake> list = session.createQuery("from SweetCake").list();
		for(SweetCake s :list){
			System.out.println(s.toString());
		}
		session.close();
		return list;
		
	}
	
	//带条件的查询：
	public List<SweetCake> getAllSweetCakesByProperty(String name){
		List<SweetCake> list = session.createQuery("from SweetCake as sc where sc.cakeName like ?").setParameter(0, "%"+name+"%").list();
		for(SweetCake s :list){
			System.out.println(s.toString());
		}
		session.close();
		return list;
	}
		
	public static void main(String[] args) {
	 
		SweetCake sc = new SpringTest().getSweetCakeById(15);
		System.out.println(sc.toString()); 
		System.out.println("END!");
	}

}
