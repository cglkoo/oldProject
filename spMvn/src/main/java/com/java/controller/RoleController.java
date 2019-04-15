package com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.entity.Page;
import com.java.entity.PageSupport;
import com.java.entity.Role;
import com.java.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	/*@RequestMapping("list")
	public String list(Model model){
 		List<Role> roleList = roleService.getList();
		model.addAttribute("roleList", roleList);
		return "role/list";
	}*/
	//分页展示角色
	@RequestMapping("list")
	public String getRolesBykeyWord(Model model,String keyword,String flag,Page page,Long count,String pageIndex,Long pageSize){
		flag=(flag==null?"":flag);
		if("sch".equals(flag)){
			keyword=(keyword==null?"":keyword);
		}else{
			keyword="";
		}
		pageSize=(pageSize==null||pageSize==0?2:pageSize);
		//默认首页时当前页变量的值为1
		long pageNo=Long.parseLong((pageIndex==null||pageIndex.equals(""))?"1":pageIndex);
		count=roleService.getRoleLines(keyword);
		page = PageSupport.getPage(count,pageNo,pageSize);  
		List<Map<String, Object>> roleList = roleService.getRoleList(keyword,page);
		model.addAttribute("roleList",roleList);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		return "role/list";
	}
	//角色单个删除
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(int roleId){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=roleService.deleteRole(roleId);
		if(result>0){
			resultMap.put("data", 1);
			resultMap.put("keyword","");
		}else{
			resultMap.put("data", 0);
			
		}
		return resultMap;
	}
	//角色批量删除
	@RequestMapping("deleteAll")
	@ResponseBody 
	public Map<String,Object> deletAll(int [] ids,Model model){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=0;
		for(int i =0;i<ids.length;i++){
			result=roleService.deleteRole(ids[i]);
			if(result<=0){
				resultMap.put("data",0);
				break;
			}
		}
		if(result>0){
			resultMap.put("data",1);
			resultMap.put("keyword","");
		}
		return resultMap;
	}
	
	//添加与修改
	@RequestMapping("input")
	public String input(){
		return "role/input";
	}
	//角色添加
	@RequestMapping("add")
	public String add(Model model,Role role){
		int result=roleService.addRole(role);
		if(result>0){
			model.addAttribute("info", "添加成功");
		}else{
			model.addAttribute("info", "添加失败");
		}	 
		return "role/input";
	}
	//用户名重名验证
	@RequestMapping("checkName")
	@ResponseBody
	public  Map<String,Object> checkRoleName(String roleName){
		Map<String,Object> resultMap = new HashMap<String, Object>();
	 	long resule=roleService.getRolebyCheckName(roleName);
	 	if(resule>0){
	 		resultMap.put("data",1);
	 	}else{
	 		resultMap.put("data",0);
	 	}
		return  resultMap;
	}
	
	
	
	
	
}
