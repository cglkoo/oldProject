package com.hzitxx.spring.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Role;
import com.hzitxx.spring.demo.model.Page;
import com.hzitxx.spring.demo.model.PageSupport;
import com.hzitxx.spring.demo.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleContorller {
	
	@Autowired
	private RoleService roleService;
	
	//分页展示角色
	@RequestMapping("list")
	public String getRolesBykeyWord(Model model,String keyword,Integer pageSize,String pageIndex,String flag){
		/*flag=(flag==null?"":flag);
		if("sch".equals(flag)){
			keyword=(keyword==null?"":keyword);
		}else{
			keyword="";
		}*/
		keyword=(keyword==null?"":keyword);
		long count=roleService.getRoleLines(keyword);
		//默认首页时当前页变量的值为1
		long pageNo=Long.parseLong((pageIndex==null||pageIndex.equals(""))?"1":pageIndex);
		pageSize=(pageSize==null||pageSize==0?2:pageSize);
		Page page = PageSupport.getPage(count,pageNo,pageSize);  
		List<Role> roleList =this.roleService.getRoleList(keyword,page,"rId");
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
		}
		return resultMap;
	}
	
	//添加与修改
	@RequestMapping("input")
	public String input(String roleId,Model model){
		Role role=new Role();
		if(roleId!=null && roleId.length()>0){
			int id=Integer.parseInt(roleId);
			role=roleService.getRolebyId(id);
		}
		model.addAttribute("role",role);
		return "role/input";
	}
	//角色添加
	@RequestMapping("add")
	public String add(Role role){
		if(null != role.getrId()&& role.getrId()>0){
			roleService.updateRole(role);
		}else{
			roleService.addRole(role);
		}	 
		return "redirect:/role/list.action";
	}
	//用户名重名验证
	@RequestMapping("checkName")
	@ResponseBody
	public  Map<String,Object> checkRoleName(String roleName){
		Map<String,Object> resultMap = new HashMap<String, Object>();
	 	Role resule=roleService.getRolebyCheckName(roleName);
	 	if(null!=resule){
	 		resultMap.put("data",1);
	 	}else{
	 		resultMap.put("data",0);
	 	}
		return  resultMap;
	}
	
	
	
	
	
}
