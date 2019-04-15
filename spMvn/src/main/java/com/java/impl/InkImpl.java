package com.java.impl;

import com.java.service.Ink;

public class InkImpl implements Ink {
	
	private String inkType;
	
	@Override
	public String getInk() {
		return inkType;
	}

	public String getInkType() {
		return inkType;
	}

	public void setInkType(String inkType) {
		this.inkType = inkType;
	}
	
	

}
