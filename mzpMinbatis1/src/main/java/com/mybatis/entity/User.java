package com.mybatis.entity;

public class User extends BaseEntity{
	
	private int uId;
	private String uName;
	private String uPwd;
	private String uIcon;

	public User() {
		super();
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getuIcon() {
		return uIcon;
	}

	public void setuIcon(String uIcon) {
		this.uIcon = uIcon;
	}

	public User(int uId, String uName, String uPwd, String uIcon) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPwd = uPwd;
		this.uIcon = uIcon;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uPwd=" + uPwd
				+ ", uIcon=" + uIcon + "]";
	}

	

	
	

}
