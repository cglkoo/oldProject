package com.hzitxx.spring.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Hobby;
import com.hzitxx.spring.demo.service.HobbyService;
import com.hzitxx.spring.demo.vo.ResponseInfo;

@Controller
@RequestMapping("/hobby")
public class HobbyController {
	
	@Autowired
	private HobbyService hobbyService;
	
	@RequestMapping("list")
	public String index(Model model){
		List<Hobby> hobbyList = hobbyService.getList();
		model.addAttribute("hobbyList", hobbyList);
		return "hobby/list";
	}

	@RequestMapping("deleteHobby")
	@ResponseBody
	public ResponseInfo deleteHobby(String hobbyId) {
		hobbyId=(hobbyId==null||hobbyId.equals("")?"0":hobbyId);
		int count = this.hobbyService.deleteHobbyById(Integer.parseInt(hobbyId));
		ResponseInfo info = new ResponseInfo();
		info.setMessage(count>0?"删除成功！":"删除失败！");
		return info;
	}
	
 
	
}
