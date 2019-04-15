package com.java.impl;

import com.java.service.IPage;

public class PageImpl implements IPage {
	
	private String pageType;
	
	@Override
	public String getPage() {
		return pageType;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	
}
