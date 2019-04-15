package com.mybatis.entity;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseDaoSqlSession {
	    //全局
		public static SqlSession sqlSession = null;
		//public static SqlSessionFactory sessionFactory = null;
		//extends SqlSessionDaoSupport
		static{
			ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		    sqlSession = (SqlSession) ctx.getBean("sqlSession"); 
		    //从会话工厂获取一个session，无需再每次调用后关闭！关闭反而出错
		}
		 
		public SqlSession getSession(){
			return this.sqlSession;
		}
}
