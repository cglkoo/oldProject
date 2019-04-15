/**
 * 
 */
package com.hzitxx.spring.demo.model;

/**
 * @author 闵老师
 * 日期：2017年4月27日 : 下午5:27:49
 * 功能：
 */
public class TBlUser {
	//属性；
	int uId;
	String userName;
	String userPwd;
	String userIcon;
	
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
	@Override
	public String toString() {
		return "TBlUser [uId=" + uId + ", userName=" + userName + ", userPwd="
				+ userPwd + "]";
	}
	public TBlUser(int uId, String userName, String userPwd) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public TBlUser() {
		super();
	}
	

}
