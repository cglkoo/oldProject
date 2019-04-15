package com.mybatis.entity;

public class BaseEntity {
	private int pageIndex=1; //默认是第1页！
	private int start=0;     //默认从第0条数据开始查询；
	private int size=2;     //默认页面size;
	private int end;
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getStart() {
		this.start=(pageIndex-1)*size;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getEnd() {
		end=pageIndex*size;
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}

}
