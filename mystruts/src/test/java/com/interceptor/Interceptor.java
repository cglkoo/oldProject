package com.java.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Interceptor extends AbstractInterceptor{

	public Interceptor() {
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start = System.currentTimeMillis();
		String result=invocation.invoke();
		long end = System.currentTimeMillis();
		System.out.println("拦截所用的时间 （毫秒）："+(end-start));
		return result;
	}

}
