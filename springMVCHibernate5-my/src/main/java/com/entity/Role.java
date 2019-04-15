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
@Table(name = "t_role")  //声明在数据库中自动生成的表名为t_role
public class Role {
	@Id//声明此列为主键
	@GeneratedValue(strategy = GenerationType.IDENTITY)//根据不同数据库自动选择合适的id生成方案，这里使用mysql,为自增型
	private Integer rId;
	@Column(name="rName",nullable=false)
	private String rName;
	 
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}
	
	
}
