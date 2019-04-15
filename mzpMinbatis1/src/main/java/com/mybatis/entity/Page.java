package com.mybatis.entity;

public class Page {
	/**
	 * 当前页码，默认为1；
	 */
	private long pageNo = 1;
	/**
	 * 总记录数量
	 */
	private long totalCount;
	/**
	 * 总计页数
	 */
	private long totalPage;
	/**
	 * sql分页查询时起始位置
	 */
	private long position;
	/**
	 * 每页条数	  默认2条
	 */
	private long pageSize = 2;
	
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
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", position=" + position
				+ ", pageSize=" + pageSize + "]";
	}
	

}
