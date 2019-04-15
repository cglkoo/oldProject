package com.mysql.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;








import com.mybatis.entity.Clazz;
import com.mybatis.entity.Student;

public class TestStuName {
	
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
		
		//增加学生
		public void addStudent(Student stu){
			SqlSession sqlsession = this.getSqlSession();
			int c = sqlsession.insert("com.StuNameMapper.addStudent", stu);
			sqlsession.close();
			System.out.println(stu.getStuId());
			System.out.println("保存:"+c);
		}
		
		public void getStuListBycId(Clazz cz){
			SqlSession sqlsession =this.getSqlSession();
			List<Student> list = new ArrayList<Student>();
			list= sqlsession.selectList("com.StuNameMapper.getStuListBycId",cz);
			if(list!=null){
				for(Student b : list){
					System.out.println(b);
				}
			}
			sqlsession.close();
			System.out.println("查询结束。。。");
		}
		
		//查询(两表联合查询,学生对班级，多对一)
		public void getStuAndClassName(){
			List<Student> list=new ArrayList<Student>();
			SqlSession sqlsession = this.getSqlSession();
			list = sqlsession.selectList("com.StuNameMapper.getStuAndClassName");
			for(Student b : list){
				System.out.println(b);
			}
			sqlsession.close();
			System.out.println("查询结束。。。");
		}
		
		public static void main(String[] args) {
			TestStuName test=new TestStuName();
			Clazz cz = new Clazz();
			cz.setcId(2);
			test.getStuListBycId(cz);
			//test.getStuAndClassName();
			
		}

}
