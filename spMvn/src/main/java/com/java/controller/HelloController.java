package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	public HelloController() {
	}
	@RequestMapping("/index")
    public String test(Model model){
    	model.addAttribute("hello", "学会玩springMVC！了");
    	return "hello";
    }
}
