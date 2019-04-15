/**
 * 
 */
package com.hzitxx.spring.demo.model;

/**
 * @author 闵老师
 * 日期：2017年4月28日 : 上午10:12:14
 * 功能：角色实体类；
 */
public class Role {

	int rId;
	String rName;
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public Role(int rId, String rName) {
		super();
		this.rId = rId;
		this.rName = rName;
	}
	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rName=" + rName + "]";
	}
	public Role() {
		super();
	}
	
}
