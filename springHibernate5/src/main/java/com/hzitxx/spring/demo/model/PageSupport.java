package com.hzitxx.spring.demo.model;

public class PageSupport {
	public static Page getPage(long count,long pageNo,int pageSize){
		//count：所有记录条数； pageNo:当前页索引，默认为1。
		if(pageNo==0){
			pageNo=1;
		}
		Page page = new Page();
		page.setTotalCount(count);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize==0?page.getPageSize():pageSize);
		// 计算总页数；
		long totalPage = count / page.getPageSize();
		if(count % page.getPageSize() > 0){
			totalPage++;
		}
		if(pageNo>totalPage){
			pageNo=totalPage;
		}
		page.setTotalPage(totalPage);
		// 计算起始页；
		long position = (page.getPageNo() - 1) * page.getPageSize();
		page.setPosition(position);
		return page;
	}

}
