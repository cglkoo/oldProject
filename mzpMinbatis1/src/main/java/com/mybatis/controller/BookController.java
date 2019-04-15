package com.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.entity.Book;
import com.mybatis.entity.Page;
import com.mybatis.entity.PageSupport;
import com.mybatis.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private IBookService bookService;
	
	@RequestMapping("list")
	public String list(Model model,String keyword,Integer pageSize,String pageIndex,String flag){
	    flag=(flag==null?"":flag);
		/*if("sch".equals(flag)){
			keyword=(keyword==null?"":keyword);
		}else{
			keyword="";
		}*/
		keyword=(keyword==null?"":keyword);
		long count=bookService.getBookLines("%"+keyword+"%");
		//默认首页时当前页变量的值为1
		long pageNo=Long.parseLong((pageIndex==null||pageIndex.equals(""))?"1":pageIndex);
		pageSize=(pageSize==null||pageSize==0?2:pageSize);
		Page page = PageSupport.getPage(count,pageNo,pageSize);
		Book book = new Book();
		book.setbName("%"+keyword+"%");
		book.setPageIndex((int)pageNo);
		book.setSize(pageSize);
		List<Book> bookList =this.bookService.getBookList(book);
		model.addAttribute("bookList",bookList);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		return "book/list";
	}
	
	//单个删除
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(int bookId){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=bookService.delBook(bookId);
		if(result>0){
			resultMap.put("data", 1);
		}else{
			resultMap.put("data", 0);
		}
		return resultMap;
	}
	//批量删除
	@RequestMapping("deleteAll")
	@ResponseBody 
	public Map<String,Object> deletAll(int [] ids,Model model){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=0;
		for(int i =0;i<ids.length;i++){
			result=bookService.delBook(ids[i]);
			if(result<=0){
				resultMap.put("data",0);
				break;
			}
		}
		if(result>0){
			resultMap.put("data",1);
		}
		return resultMap;
	}
	
	@RequestMapping("update/{bId}")
	public String getBookById(@PathVariable int bId,Model model){
		Book book = new Book();
		if(bId>0){
			 book=bookService.getBookById(bId);
		}
		model.addAttribute("book",book);
		return "book/input";
	}
	@RequestMapping("add")
	public String addBook(Book bk){
		if(bk.getbId()>0){
		    bookService.updateBook(bk);
		}else{
			bookService.addBook(bk);
		}
		return "redirect:/book/list";
	}

	
}
