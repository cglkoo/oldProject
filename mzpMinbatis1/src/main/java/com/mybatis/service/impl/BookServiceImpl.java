package com.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.dao.IBookDao;
import com.mybatis.entity.Book;
import com.mybatis.service.IBookService;
@Service("IBookService")
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookDao bookDao;
	@Override
	public int addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public int delBook(int id) {
		return bookDao.delBook(id);
	}

	@Override
	public int updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	@Override
	public List<Book> getBookList(Book book) {
		return bookDao.getBookList(book);
	}

	@Override
	public long getBookLines(String keyword) {
		return bookDao.getBookLines(keyword);
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

}
