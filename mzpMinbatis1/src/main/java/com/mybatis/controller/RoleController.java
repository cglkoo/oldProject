package com.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.entity.Role;
import com.mybatis.entity.Page;
import com.mybatis.entity.PageSupport;
import com.mybatis.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("list")
	public String list(Model model,String keyword,Integer pageSize,String pageIndex,String flag){
	    flag=(flag==null?"":flag);
		/*if("sch".equals(flag)){
			keyword=(keyword==null?"":keyword);
		}else{
			keyword="";
		}*/
		keyword=(keyword==null?"":keyword);
		long count=roleService.getRoleLines("%"+keyword+"%");
		//默认首页时当前页变量的值为1
		long pageNo=Long.parseLong((pageIndex==null||pageIndex.equals(""))?"1":pageIndex);
		pageSize=(pageSize==null||pageSize==0?2:pageSize);
		Page page = PageSupport.getPage(count,pageNo,pageSize);
		
		Role role = new Role();
		role.setrName("%"+keyword+"%");
		role.setPageIndex((int)pageNo);
		role.setSize(pageSize);
		List<Role> roleList =this.roleService.getRoleList(role);
		model.addAttribute("roleList",roleList);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		return "role/list";
	}
	
	//单个删除
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(int roleId){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=roleService.delRole(roleId);
		if(result>0){
			resultMap.put("data", 1);
		}else{
			resultMap.put("data", 0);
		}
		return resultMap;
	}
	//批量删除
	@RequestMapping("deleteAll")
	@ResponseBody 
	public Map<String,Object> deletAll(int [] ids,Model model){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=0;
		for(int i =0;i<ids.length;i++){
			result=roleService.delRole(ids[i]);
			if(result<=0){
				resultMap.put("data",0);
				break;
			}
		}
		if(result>0){
			resultMap.put("data",1);
		}
		return resultMap;
	}
	@RequestMapping("update/{rId}")
	public String getRoleById(@PathVariable int rId,Model model){
		Role role=new Role();
		if(rId>0){
			role=roleService.getRoleById(rId);
		}
		model.addAttribute("role",role);
		return "role/input";
	}
	@RequestMapping("add")
	public String addRole(Role role){
		if(role.getrId()>0){
		    roleService.updateRole(role);
		}else{
			roleService.addRole(role);
		}
		return "redirect:/role/list";
	}

	
}
