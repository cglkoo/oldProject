package com.hzitxx.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.TBlUser;

@Controller
@RequestMapping("/hello")
public class HelloController{
	
	@RequestMapping("index")
	public String hello(Model model){
		model.addAttribute("hello", "Hello world...");
		//int i = 1/0;
		//System.out.println(i);
		return "user/hello";
	}
	
	@RequestMapping("sayHello")
	public String process(String id){
		System.out.println("id is:" + id);
		int j = 40/0;
		System.out.println(j);
		return "";
	}
	
	@RequestMapping("dd/{id}/{name}")
	public String dd(@PathVariable int id,@PathVariable String name,String pwd){
		System.out.println("id is:" + id);
		TBlUser user = new TBlUser();
		user.setuId(id);
		user.setUserName(name);
		user.setUserPwd(pwd);
		System.out.println(user.toString());
		return null;
	}
	
	@RequestMapping("dd2")
	public String dd(TBlUser user){
		System.out.println(user.toString());
		return null;
	}
	
	

}
