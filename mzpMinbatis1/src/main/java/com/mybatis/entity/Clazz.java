package com.mybatis.entity;

import java.util.List;

public class Clazz {
	
	private int cId;
	private String cName;
	private List<Student> slist;
	
	
	public Clazz(int cId, String cName, List<Student> slist) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.slist = slist;
	}

	public Clazz() {
	}
	
	public List<Student> getSlist() {
		return slist;
	}

	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}

	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "Clazz [cId=" + cId + ", cName=" + cName + ", slist=" + slist
				+ "]";
	}

}
