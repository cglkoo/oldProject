package com.java.entity;

public class TBlUser {
	
	private String uId;
	private String userName;
	private String userPwd;
	private String userIcon;
	
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	@Override
	public String toString() {
		return "TBlUser [uId=" + uId + ", userName=" + userName + ", userPwd="
				+ userPwd + ", userIcon=" + userIcon + "]";
	}

	

}
