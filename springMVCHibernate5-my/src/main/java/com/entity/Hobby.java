/**
 * 
 */
package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                  //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "t_hobby") //声明在数据库中自动生成的表名为t_hobby
public class Hobby{
	
	@Id//声明此列为主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)//根据不同数据库自动选择合适的id生成方案，这里使用mysql,为自增型
	private int hId;
	@Column(name="hName",nullable=false)
	private String hName;
	
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public Hobby(int hId, String hName) {
		super();
		this.hId = hId;
		this.hName = hName;
	}
	public Hobby() {
		super();
	}
	@Override
	public String toString() {
		return "Hobby [hId=" + hId + ", hName=" + hName + "]";
	}
	 
}
