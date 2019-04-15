package com.hzitxx.spring.demo.vo;

public class ResponseInfo {

	/**
	 * 返回的代码信息
	 * 200表示成功
	 */
	private int code = 200;
	
	/**
	 * 返回给前端的信息内容
	 */
	private Object data;
	
	/**
	 * 返回给前端的信息描述
	 */
	private String message;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
