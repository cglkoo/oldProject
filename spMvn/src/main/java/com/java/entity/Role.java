
package com.java.entity;

public class Role {

	private int rId;
	private String rName;
	
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public Role(int rId, String rName) {
		super();
		this.rId = rId;
		this.rName = rName;
	}
	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rName=" + rName + "]";
	}
	public Role() {
		super();
	}
	
}
