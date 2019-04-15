
package com.user.action;

public class TBlUser {  //用户实体
	
	private int uId;
	private String userName;
	private String userPwd;
	private String userIcon;
	
	public TBlUser() {
		super();
	}
	public TBlUser(int uId, String userName, String userPwd, String userIcon) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userIcon = userIcon;
	}

	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
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
	
	

}
