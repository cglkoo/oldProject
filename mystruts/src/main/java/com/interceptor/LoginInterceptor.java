package com.java.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String,Object> params = invocation.getInvocationContext().getParameters();
		if(params.get("userName")!=null){
			return invocation.invoke();
		}else{
			//解耦的方式访问Servlet API:Application Program Interface;
			Map<String, Object> session = invocation.getInvocationContext().getSession();
			String user = (String)session.get("user");
			if(user==null){
				session.put("msg", "第二个拦截器启动了：又有一个用户没有登录！");
				System.out.println("第二个拦截器启动了：又有一个用户没有登录！");
				return Action.INPUT;
			}else{
				return invocation.invoke();
			}
		}
		
		
	}

}
