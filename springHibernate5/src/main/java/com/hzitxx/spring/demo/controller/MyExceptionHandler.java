package com.hzitxx.spring.demo.controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class MyExceptionHandler {

	/*@ExceptionHandler(value = {Exception.class})
	public String handleException(Model model){
		model.addAttribute("info", "天啊，出错了！！！");
		return "common/exception";
	}
	*/
}
