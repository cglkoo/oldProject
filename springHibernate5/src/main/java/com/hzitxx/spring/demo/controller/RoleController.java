package com.hzitxx.spring.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Role;
import com.hzitxx.spring.demo.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("list")
	public String index(Model model){
		List<Role> roleList = roleService.getList();
		model.addAttribute("roleList", roleList);
		return "role/list";
	}

	@RequestMapping("deleteRolebyRid")
	public ModelAndView deleteRolebyRName(HttpServletRequest request){
		String rName = request.getParameter("rName")==null?"":request.getParameter("rName");
		int result = roleService.deleteRoleByRName(rName);
		List<Role> roleList = roleService.getList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("role/list");
		mv.addObject("roleList", roleList);
		return mv;
	}
	
}
