package com.kaokaoba.paper;

public class Paper {
	int pId;
	String pName;
	String pType;
	int pCount;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public int getpCount() {
		return pCount;
	}
	public void setpCount(int pCount) {
		this.pCount = pCount;
	}
	public Paper() {
		super();
	}
	public Paper(int pId, String pName, String pType, int pCount) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pType = pType;
		this.pCount = pCount;
	}
	@Override
	public String toString() {
		return "Paper [pId=" + pId + ", pName=" + pName + ", pType=" + pType
				+ ", pCount=" + pCount + "]";
	}

}
