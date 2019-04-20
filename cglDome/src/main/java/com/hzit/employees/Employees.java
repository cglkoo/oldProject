package com.hzit.employees;
/**
 * 
 * @author 应传富
 *日期:2017年5月4日
 *功能:用户实体类
 */
public class Employees {
	private int userId;
	private String userName;
	private String userPwd;
	private String sex;
	private String mobile;
	private String borth;
	private String entry;
	
	public Employees(){
	}
	
	public Employees(int userId, String userName, String userPwd, String sex, String mobile, String borth,
			String entry) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.sex = sex;
		this.mobile = mobile;
		this.borth = borth;
		this.entry = entry;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBorth() {
		return borth;
	}

	public void setBorth(String borth) {
		this.borth = borth;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	@Override
	public String toString() {
		return "Employees [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", sex=" + sex
				+ ", mobile=" + mobile + ", borth=" + borth + ", entry=" + entry + "]";
	}
	
}
