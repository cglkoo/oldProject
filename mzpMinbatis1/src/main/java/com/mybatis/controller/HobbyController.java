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

import com.mybatis.entity.Hobby;
import com.mybatis.entity.Page;
import com.mybatis.entity.PageSupport;
import com.mybatis.service.IHobbyService;

@Controller
@RequestMapping("/hobby")
public class HobbyController {
	@Autowired
	private IHobbyService hobbyService;
	
	@RequestMapping("list")
	public String list(Model model,String keyword,Integer pageSize,String pageIndex,String flag){
	    flag=(flag==null?"":flag);
		/*if("sch".equals(flag)){
			keyword=(keyword==null?"":keyword);
		}else{
			keyword="";
		}*/
		keyword=(keyword==null?"":keyword);
		long count=hobbyService.getHobbyLines("%"+keyword+"%");
		//默认首页时当前页变量的值为1
		long pageNo=Long.parseLong((pageIndex==null||pageIndex.equals(""))?"1":pageIndex);
		pageSize=(pageSize==null||pageSize==0?2:pageSize);
		Page page = PageSupport.getPage(count,pageNo,pageSize);
		
		Hobby hobby = new Hobby();
		hobby.sethName("%"+keyword+"%");
		hobby.setPageIndex((int)pageNo);
		hobby.setSize(pageSize);
		List<Hobby> hobbyList =this.hobbyService.getHobbyList(hobby);
		model.addAttribute("hobbyList",hobbyList);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		return "hobby/list";
	}
	
	//单个删除
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(int hobbyId){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=hobbyService.delHobby(hobbyId);
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
			result=hobbyService.delHobby(ids[i]);
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
	@RequestMapping("update/{hId}")
	public String getHobbyById(@PathVariable int hId,Model model){
		Hobby hobby = new Hobby();
		if(hId>0){
			hobby=hobbyService.getHobbyById(hId);
		}
		model.addAttribute("hobby",hobby);
		return "hobby/input";
	}
	@RequestMapping("add")
	public String addHobby(Hobby hobby){
		if(hobby.gethId()>0){
		    hobbyService.updateHobby(hobby);
		}else{
			hobbyService.addHobby(hobby);
		}
		return "redirect:/hobby/list";
	}

	
}
