package com.java.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.entity.Printer;
import com.java.entity.User;
import com.java.service.UserService;

public class SpringTest {

	public SpringTest() {

	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext cxt= new ClassPathXmlApplicationContext("applicationContext.xml");
		User user=(User) cxt.getBean("user");
		User user2=(User) cxt.getBean("user");
		System.out.println(user.toString());
		System.out.println(user==user2);
		
		
		Printer print=(Printer)cxt.getBean("print");
		print.print();
		
		UserService userService=(UserService) cxt.getBean("userService");
		userService.doAdd("aaa","bbbb","cccc");
		userService.doUpdate();
		userService.doDelete();
	}

		
}
