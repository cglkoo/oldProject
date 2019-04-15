/**
 * 
 */
package com.hzitxx.spring.demo.model;

/**
 * @author 闵老师
 * 日期：2017年4月28日 : 上午10:12:14
 * 功能：角色实体类；
 */
public class Hobby{

	private int hId;
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
