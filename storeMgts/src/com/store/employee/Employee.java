package com.store.employee;

import java.util.Date;

public class Employee {
	int userId;
	String userName;
	String userPwd;
	String sex;
	String mobile;
	Date date;
	Date entry;

	public Employee() {
	}

	public Employee(int userId, String userName, String userPwd, String sex, String mobile, Date date, Date entry) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.sex = sex;
		this.mobile = mobile;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEntry() {
		return entry;
	}

	public void setEntry(Date entry) {
		this.entry = entry;
	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", sex=" + sex
				+ ", mobile=" + mobile + ", date=" + date + ", entry=" + entry + "]";
	}
	

}
