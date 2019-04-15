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

/**
 * @author 闵老师
 * 日期：2017年4月28日 : 上午10:12:14
 * 功能：角色实体类；
 */
@Entity                  //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "t_role") //声明在数据库中自动生成的表名为t_role
public class Role {
	@Id//声明此列为主键
	@GeneratedValue(strategy = GenerationType.AUTO)//根据不同数据库自动选择合适的id生成方案，这里使用mysql,为自增型
	private Integer Id;
	
	@Column(name="rName",nullable=false)
	private String rName;
	 
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public Role(Integer Id, String rName) {
		super();
		this.Id = Id;
		this.rName = rName;
	}
	@Override
	public String toString() {
		return "Role [Id=" + Id + ", rName=" + rName + "]";
	}
	public Role() {
		super();
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
}
