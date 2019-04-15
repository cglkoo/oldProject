package com.mysql.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.entity.Book;
public class TestBook {
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
	//增加
	public void addBook(Book bk){
		SqlSession sqlsession = this.getSqlSession();
		int c = sqlsession.insert("com.BookMapper.addBook", bk);
		sqlsession.close();
		System.out.println(bk.getbId());
		System.out.println("保存成功！"+c);
	}
	
	//删除
	public void delBook(int bId){
		SqlSession sqlsession = this.getSqlSession();
		int c=sqlsession.delete("com.BookMapper.delBook", bId);
		sqlsession.close();
		System.out.println("删除成功！"+c);
	}
	//修改
	public void updateBook(Book bk){
		SqlSession sqlsession = this.getSqlSession();
		int c = sqlsession.update("com.BookMapper.updateBook", bk);
		sqlsession.close();
		System.out.println("修改成功！"+c);
	}
	//查询(所有)
	public void getAllBook(Book bk){
		List<Book> list = new ArrayList<Book>();
		System.out.println("查询第"+bk.getPageIndex()+"页的内容：");
		bk.setbName("%"+(bk.getbName()==null?"":bk.getbName())+"%");
		bk.setbAuthor("%"+(bk.getbAuthor()==null?"":bk.getbAuthor())+"%");
		bk.setbPublisher("%"+(bk.getbPublisher()==null?"":bk.getbPublisher())+"%");
		SqlSession sqlsession = this.getSqlSession();
		list = sqlsession.selectList("com.BookMapper.getAllBook", bk);
		for(Book b : list){
			System.out.println(b);
		}
		sqlsession.close();
		System.out.println("查询结束。。。");
	}
	 
	//查询记录数
	public void getCount(String keyword){
		SqlSession sqlsession = this.getSqlSession();
		long c = sqlsession.selectOne("com.BookMapper.getCount",keyword);
		sqlsession.close();
		System.out.println("记录数："+c);
	}
	/*
	//查询(所有带条件的)
	public void getAllBookByBook(Book bk){
		List<Book> list = new ArrayList<Book>();
		
		bk.setbName("%"+bk.getbName()+"%");
		list = sqlsession.selectList("com.BookMapper.getAllBookByBook",bk);
		for(Book b : list){
			System.out.println(b);
		}
		sqlsession.close();
		System.out.println("查询结束。。。");
	}
	
	
	//查询(带多个条件的)
	public void getAllBookByBook2(Book bk){
		List<Book> list = new ArrayList<Book>();
		
		bk.setbName("%"+bk.getbName()+"%");
		bk.setbAuthor("%"+bk.getbAuthor()+"%");
		bk.setbPublisher("%"+bk.getbPublisher()+"%");
		list = sqlsession.selectList("com.BookMapper.getAllBookByBook2",bk);
		for(Book b : list){
			System.out.println(b);
		}
		sqlsession.close();
		System.out.println("查询结束。。。");
	}*/
	public static void main(String[] args) {
		//new TestBook().addBook(new Book("Java从入门到精通2","闵老师","即将出版社"));
		//new TestBook().delBook(665567);
		//new TestBook().updateBook(new Book(665569,"Java从入门到精通","张凡","即将出版社"));
		//new TestBook().getAllBook();
		
		 Book b = new Book();
		 b.setPageIndex(3);
		 
		 new TestBook().getCount("榜");
// 
	}

}
