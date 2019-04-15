package com.store.notice;

public class Notice {
	int nId;
	String nName;
	String nContent;
	String nDate;
	
	public Notice() {
		super();
	}
	public Notice(int nId, String nName, String nContent, String nDate) {
		super();
		this.nId = nId;
		this.nName = nName;
		this.nContent = nContent;
		this.nDate = nDate;
	}
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnDate() {
		return nDate;
	}
	public void setnDate(String nDate) {
		this.nDate = nDate;
	}
	@Override
	public String toString() {
		return "Notice [nId=" + nId + ", nName=" + nName + ", nContent=" + nContent + ", nDate=" + nDate + "]";
	}

	

}
