package com.java.entity;

public class Hobby {
	private int hId;
	private String hName;
	
	public Hobby() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Hobby [hId=" + hId + ", hName=" + hName + "]";
	}

	public Hobby(int hId, String hName) {
		super();
		this.hId = hId;
		this.hName = hName;
	}

	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}

	
	
}
