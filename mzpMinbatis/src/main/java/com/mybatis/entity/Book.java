package com.mybatis.entity;

public class Book extends BaseEntity{
	
	private long bId;
	private String bName;
	private String bAuthor;
	private String bPublisher;
	public long getbId() {
		return bId;
	}
	public void setbId(long bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public String getbPublisher() {
		return bPublisher;
	}
	public void setbPublisher(String bPublisher) {
		this.bPublisher = bPublisher;
	}
	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bName=" + bName + ", bAuthor=" + bAuthor
				+ ", bPublisher=" + bPublisher + "]";
	}
	public Book(long bId, String bName, String bAuthor, String bPublisher) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
	}
	public Book(String bName, String bAuthor, String bPublisher) {
		super();
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bPublisher = bPublisher;
	}
	public Book() {
		super();
	}
	public Book(String bName) {
		super();
		this.bName = bName;
	}
	

}
