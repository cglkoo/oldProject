package com.java.entity;

public class ResponseInfo {  //文件上传的返回信息类
	
	private int code=200;   //返回代码信息，200表示成功
	private Object data;    //返回到前端的内容信息
	private String message;  //返回到前端的信息描述
	
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
