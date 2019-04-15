/**
 * 
 */
package com.mybatis.entity;


public class Hobby extends BaseEntity{

	private int hId;
	private String hName;
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
	public Hobby(int hId, String hName) {
		super();
		this.hId = hId;
		this.hName = hName;
	}
	public Hobby() {
		super();
	}
	@Override
	public String toString() {
		return "Hobby [hId=" + hId + ", hName=" + hName + "]";
	}
	 
}
