package com.mysql.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.entity.Clazz;
import com.mybatis.entity.Student;
public class TestClassName {
	//全局；
	public static SqlSession sqlSession = null;
	public static SqlSessionFactory sessionFactory = null;
	static{
		//读取mybatis的核心配置文件；
		Reader r = null;
		try {
			r = Resources.getResourceAsReader("mybatis-config.xml");
			//创建session工厂
			sessionFactory = new SqlSessionFactoryBuilder().build(r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public SqlSession getSqlSession(){
		//获取sqlSession；
		sqlSession = sessionFactory.openSession();
		return sqlSession;
	}
	//增加班级
	public void addClassName(Clazz bk){
		SqlSession sqlsession = this.getSqlSession();
		int c = sqlsession.insert("com.ClassNameMapper.addClassName", bk);
		sqlsession.close();
		System.out.println(bk.getcId());
		System.out.println("保存:"+c);
	}
	
	
	//删除班级
	public void delClassName(int classId){
		SqlSession sqlsession = this.getSqlSession();
		Clazz cn = new Clazz();
		cn.setcId(classId);
		int c = sqlsession.delete("com.ClassNameMapper.delClassName", cn);
		sqlsession.close();
		System.out.println("删除:"+c);
	}
	
	//删除班级2
	public void delClassName2(int classId){
		SqlSession sqlsession = this.getSqlSession();
		Map<String,Object> map = new HashMap<String,Object>();
		map.putIfAbsent("classId", classId);
		int c = sqlsession.delete("com.ClassNameMapper.delClassName2", map);
		sqlsession.close();
		System.out.println("删除:"+c);
	}
	
	//查询(不带条件的)班级
	public void getAllClassName(){
		List<Clazz> list = new ArrayList<Clazz>();
		SqlSession sqlsession = this.getSqlSession();
		list = sqlsession.selectList("com.ClassNameMapper.getAllClassName2");
		for(Clazz b : list){
			System.out.println(b);
		}
		sqlsession.close();
		System.out.println("查询结束。。。");
	}
	
	//查询(两表联合查询)
	public void getAllClassName2(){
		List<Clazz> list = new ArrayList<Clazz>();
		SqlSession sqlsession = this.getSqlSession();
		list = sqlsession.selectList("com.ClassNameMapper.getAllClassName2");
		for(Clazz b : list){
			System.out.println(b);
			if(null != b.getSlist()){
				List<Student> slist = b.getSlist();
				for(Student s : slist){
					System.out.println(s);
				}
			}
		}
		sqlsession.close();
		System.out.println("查询结束。。。");
		}
	
	public static void main(String[] args) {
		TestClassName test=	new TestClassName();
        test.getAllClassName2();
        
    
		
		
	}
	
}
