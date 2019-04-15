package com.kaokaoba.keywords;

public class KeyWords {
	
	private int kId;
	private String kName;
	public int getkId() {
		return kId;
	}
	public void setkId(int kId) {
		this.kId = kId;
	}
	public String getkName() {
		return kName;
	}
	public void setkName(String kName) {
		this.kName = kName;
	}
	public KeyWords(int kId, String kName) {
		super();
		this.kId = kId;
		this.kName = kName;
	}
	public KeyWords() {
		super();
	}
	@Override
	public String toString() {
		return "KeyWords [kId=" + kId + ", kName=" + kName + "]";
	}
	

}
