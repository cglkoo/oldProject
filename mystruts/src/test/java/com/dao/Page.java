package com.java.dao;

public class Page {
	
	private long pageNo = 1;   //当前页码
	private long totalCount;   //总记录数量
	private long totalPage;    //总页数
	private long position;     //sql分页查询时起始位置
	private long pageSize = 5;  //每页记录数
	
	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	
	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}


}
