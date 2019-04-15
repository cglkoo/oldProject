package com.java.dao;

import javax.servlet.http.HttpServletRequest;

public class PageSupport {
	
	public static Page process(long count, HttpServletRequest request){
		
		if(null == request) return null;
		Page page = new Page();
		page.setTotalCount(count);
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		if(null != pageNo && pageNo.trim().length() > 0){
			int pn = Integer.parseInt(pageNo);
			page.setPageNo(pn);
		}
		if(null != pageSize && pageSize.trim().length() > 0){
			int ps = Integer.parseInt(pageSize);
			page.setPageSize(ps);
		}
		// 计算总页数
		long totalPage = count / page.getPageSize();
		if(count % page.getPageSize() > 0){
			totalPage++;
		}
		page.setTotalPage(totalPage);
		long position = (page.getPageNo() - 1) * page.getPageSize();
		page.setPosition(position);
		request.setAttribute("page", page);
		
		return page;
	}

}
