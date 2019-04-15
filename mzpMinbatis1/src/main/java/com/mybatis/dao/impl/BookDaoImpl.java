package com.mybatis.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.dao.IBookDao;
import com.mybatis.entity.BaseDaoSqlSession;
import com.mybatis.entity.Book;

@Repository("IBookDao")
public class BookDaoImpl extends BaseDaoSqlSession implements IBookDao {

	@Override
	public int addBook(Book book) {
		return this.getSession().insert("com.BookMapper.addBook",book);
	}
	@Override
	public int delBook(int id) {
		return this.getSession().delete("com.BookMapper.delBook", id);
	}
	@Override
	public int updateBook(Book book) {
		return this.getSession().update("com.BookMapper.updateBook", book);
	}
	@Override
	public List<Book> getBookList(Book book) {
		return this.getSession().selectList("com.BookMapper.getAllBook",book);
	}
	@Override
	public long getBookLines(String keyword) {
		return this.getSession().selectOne("com.BookMapper.getCount",keyword);

	}
	@Override
	public Book getBookById(int id) {
		return this.getSession().selectOne("com.BookMapper.getBookById",id);
	}
	
	

}
