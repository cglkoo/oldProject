package com.store.rzhi;

public class Rzhi {  //日志实体类
	private int rId; 
    private	String rContent;  
    private String rDate;
	public Rzhi() {
		
	}
	public Rzhi(int rId, String rContent, String rDate) {
		super();
		this.rId = rId;
		this.rContent = rContent;
		this.rDate = rDate;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	@Override
	public String toString() {
		return "Rzhi [rId=" + rId + ", rContent=" + rContent + ", rDate=" + rDate + "]";
	}
	

}
