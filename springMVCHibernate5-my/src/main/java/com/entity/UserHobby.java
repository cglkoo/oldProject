package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity                  //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "user_hobby")  //声明在数据库中自动生成的表名为t_role
public class UserHobby {
	
	@Id//声明此列为主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)//根据不同数据库自动选择合适的id生成方案，这里使用mysql,为自增型
	@Column(name="uId",nullable=false)
	private int uId;
	@Column(name="hId",nullable=false)
	private int hId;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	

}
