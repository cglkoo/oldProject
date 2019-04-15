
package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                  //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "tbl_user") //声明在数据库中自动生成的表名为t_hobby
public class TBlUser {
	@Id//声明此列为主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;
	@Column(name="userName",nullable=false)
	private String userName;
	
	@Column(name="userPwd",nullable=false)
	private String userPwd;
	
	@Column(name="userIcon",nullable=false)
	private String userIcon;
	
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
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
	public TBlUser(Integer uId, String userName, String userPwd) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public TBlUser() {
		super();
	}
	

}
