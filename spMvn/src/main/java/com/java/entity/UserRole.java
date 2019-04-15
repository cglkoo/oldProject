package com.java.entity;

public class UserRole {
	private int uId;
	private int rId;
	
	public UserRole() {
		
	}

	public UserRole(int uId, int rId) {
		super();
		this.uId = uId;
		this.rId = rId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	@Override
	public String toString() {
		return "UserRole [uId=" + uId + ", rId=" + rId + "]";
	}
	
	
	
}
