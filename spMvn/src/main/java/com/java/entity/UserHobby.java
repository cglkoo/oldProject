package com.java.entity;

public class UserHobby {
	private int uId;
	private int hId;
	public UserHobby() {
		
	}
	public UserHobby(int uId, int hId) {
		super();
		this.uId = uId;
		this.hId = hId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	@Override
	public String toString() {
		return "UserHobby [uId=" + uId + ", hId=" + hId + "]";
	}
	
}
