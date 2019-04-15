package com.hzitxx.spring.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Hobby;
import com.hzitxx.spring.demo.model.Page;
import com.hzitxx.spring.demo.model.PageSupport;
import com.hzitxx.spring.demo.service.HobbyService;

@Controller
@RequestMapping("/hobby")
public class HobbyController {
	
	@Autowired
	private HobbyService hobbyService;
	
	//分页展示角色
	@RequestMapping("list")
	public String getHobbysBykeyWord(Model model,String keyword,String flag,String pageIndex,Integer pageSize){
		/*flag=(flag==null?"":flag);
		if("sch".equals(flag)){
			keyword=(keyword==null?"":keyword);
		}else{
			keyword="";
		}*/
		keyword=(keyword==null?"":keyword);
		pageSize=(pageSize==null||pageSize==0?2:pageSize);
		//默认首页时当前页变量的值为1
		long pageNo=Long.parseLong((pageIndex==null||pageIndex.equals(""))?"1":pageIndex);
		long count=hobbyService.getHobbyLines(keyword);
		Page page = PageSupport.getPage(count,pageNo,pageSize);  
		List<Hobby> hobbyList = hobbyService.getHobbyList(keyword,page,"hId");
		model.addAttribute("hobbyList",hobbyList);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		return "hobby/list";
	}
	//角色单个删除
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(int hobbyId){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=hobbyService.deleteHobbyById(hobbyId);
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
			result=hobbyService.deleteHobbyById(ids[i]);
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
	public String input(Integer hobbyId,Model model){
		Hobby hobby = new Hobby();
		if(null !=hobbyId && hobbyId>0){
			hobby =	hobbyService.getHobbybyId(hobbyId);
		}
		model.addAttribute("hobby",hobby);
		return "hobby/input";
	}
	//角色添加
	@RequestMapping("add")
	public String add(Hobby hobby){
		if(hobby.gethId()>0){
			hobbyService.updateHobby(hobby);
		}else{
			hobbyService.addHobby(hobby);
		}
		return "redirect:list.action";
	}
	//重名验证
	@RequestMapping("checkName")
	@ResponseBody
	public  Map<String,Object> checkHobbyName(String hobbyName){
		Map<String,Object> resultMap = new HashMap<String, Object>();
	 	Hobby resule=hobbyService.getHobbybyCheckName(hobbyName);
	 	if(null!=resule){
	 		resultMap.put("data",1);
	 	}else{
	 		resultMap.put("data",0);
	 	}
		return  resultMap;
	}
 
	
}
