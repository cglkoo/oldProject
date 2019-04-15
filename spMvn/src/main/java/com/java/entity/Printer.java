package com.java.entity;

import com.java.service.IPage;
import com.java.service.Ink;

public class Printer {
	private Ink ink;
	private IPage page;
	public Printer() {
		
	}
	
	public void print(){
		System.out.println("使用"+ink.getInk()+"的墨盒和"+page.getPage()+"的纸张打印......");
	}
	
	
	public void setInk(Ink ink) {
		this.ink = ink;
	}
	public void setPage(IPage page) {
		this.page = page;
	}

	
	
}
