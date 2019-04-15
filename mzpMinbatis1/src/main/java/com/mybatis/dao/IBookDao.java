package com.mybatis.dao;

import java.util.List;

import com.mybatis.entity.Book;

public interface IBookDao {
	public int addBook(Book book);
	public int delBook(int id);
	public int updateBook(Book book);
	public List<Book> getBookList(Book book);
	public long getBookLines(String keyword);
	public Book getBookById(int id);
}
