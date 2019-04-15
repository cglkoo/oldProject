package com.kaokaoba.log;

public class Log {

	private int gId;
	private String gName;
	public Log(int gId, String gName) {
		super();
		this.gId = gId;
		this.gName = gName;
	}
	public int getgId() {
		return gId;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public Log() {
		super();
	}
	@Override
	public String toString() {
		return "Log [gId=" + gId + ", gName=" + gName + "]";
	}
	
}
