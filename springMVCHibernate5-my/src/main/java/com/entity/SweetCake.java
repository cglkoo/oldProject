package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                 //声明当前类为hibernate映射到数据库中的实体类
@Table(name = "t_cake") //声明在数据库中自动生成的表名为t_user
public class SweetCake {
    @Id//声明此列为主键
    @GeneratedValue(strategy = GenerationType.AUTO)//根据不同数据库自动选择合适的id生成方案，这里使用mysql,为自增型
	private Integer Id;
    @Column(name="cakeName",nullable=false)
	private String cakeName;
    
    @Column(name="cakeNum",nullable=false)
	private Integer cakeNum;
    
    @Column(name="cakeBrand",nullable=false)
	private String cakeBrand;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public Integer getCakeNum() {
		return cakeNum;
	}

	public void setCakeNum(Integer cakeNum) {
		this.cakeNum = cakeNum;
	}

	public String getCakeBrand() {
		return cakeBrand;
	}

	public void setCakeBrand(String cakeBrand) {
		this.cakeBrand = cakeBrand;
	}

	@Override
	public String toString() {
		return "SweetCake [Id=" + Id + ", cakeName=" + cakeName + ", cakeNum="
				+ cakeNum + ", cakeBrand=" + cakeBrand + "]";
	}

	public SweetCake() {
		 
	}

	public SweetCake(Integer id, String cakeName, Integer cakeNum,
			String cakeBrand) {
		super();
		Id = id;
		this.cakeName = cakeName;
		this.cakeNum = cakeNum;
		this.cakeBrand = cakeBrand;
	}

	public SweetCake(String cakeName, Integer cakeNum, String cakeBrand) {
		super();
		this.cakeName = cakeName;
		this.cakeNum = cakeNum;
		this.cakeBrand = cakeBrand;
	}
	

}
