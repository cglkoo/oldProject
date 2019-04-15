package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.java.entity.Page;
import com.java.entity.PageSupport;
import com.java.entity.ResponseInfo;
import com.java.entity.TBlUser;
import com.java.service.TBlUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private TBlUserService tblUserService;
	
	/*@RequestMapping("list")
	public String list(Model model){
 		List<TBlUser> userList = tblUserService.getList();
		model.addAttribute("userList", userList);
		return "user/list";
	}*/
	//分页展示用户
	@RequestMapping("list")
	public String getUsersBykeyWord(Model model,String keyword,String flag,Page page,Long count,String pageIndex,Long pageSize){
		flag=(flag==null?"":flag);
		if("sch".equals(flag)){
			keyword=(keyword==null?"":keyword);
		}else{
			keyword="";
		}
		pageSize=(pageSize==null||pageSize==0?2:pageSize);
		//默认首页时当前页变量的值为1
		long pageNo=Long.parseLong((pageIndex==null||pageIndex.equals(""))?"1":pageIndex);
		count=tblUserService.getUserLines(keyword);
		page = PageSupport.getPage(count,pageNo,pageSize);  
		List<Map<String, Object>> userList = tblUserService.getUserList(keyword,page);
		model.addAttribute("userList",userList);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		return "user/list";
	}
	//用户单个删除
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(int userId){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=tblUserService.deleteUser(userId);
		if(result>0){
			resultMap.put("data", 1);
			resultMap.put("keyword","");
		}else{
			resultMap.put("data", 0);
			
		}
		return resultMap;
	}
	//用户批量删除
	@RequestMapping("deleteAll")
	@ResponseBody 
	public Map<String,Object> deletAll(int [] ids,Model model){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=0;
		for(int i =0;i<ids.length;i++){
			result=tblUserService.deleteUser(ids[i]);
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
	
	//跳转到用户登录页面
	@RequestMapping("login")
	public String login(){
		return "user/login";
	}
	
	//跳转到用户注册页面
	@RequestMapping("reg")
	public String register(){
		return "user/reg";
	}
	
	//用户名重名验证
	@RequestMapping("checkName")
	@ResponseBody
	public  Map<String,Object> checkUserName(String userName){
		Map<String,Object> resultMap = new HashMap<String, Object>();
	 	long resule=tblUserService.getUserbyCheckName(userName);
	 	if(resule>0){
	 		resultMap.put("data",1);
	 	}else{
	 		resultMap.put("data",0);
	 	}
		return  resultMap;
	}
	//用户注册
	@RequestMapping("add")
	public String add(Model model,TBlUser user){
		int result=tblUserService.addUser(user);
		if(result>0){
			model.addAttribute("info", "注册成功");
		}else{
			model.addAttribute("info", "注册失败");
		}	 
		return "user/reg";
	}
	//图片上传
	@RequestMapping("upload")
	@ResponseBody   
	public ResponseInfo upload(HttpServletRequest request) throws IOException{
		MultipartHttpServletRequest req =(MultipartHttpServletRequest)request; //强制请求转换  
		MultipartFile file=req.getFile("userImg");     //通过表单属性input的name取得页面的文件
		String fileName=file.getOriginalFilename();    //获得文件初始名称
		String exeName=fileName.substring(fileName.lastIndexOf("."));   //截取文件后缀名
		String prefixName=Long.toString(System.currentTimeMillis());    //获得系统时间并且给文件重新命名
		String newFileName=prefixName+exeName;  //文件名加后缀
		String filePath = request.getServletContext().getRealPath("/upload"); //取得文件要上传到的服务器路径
		System.out.println("这是啥路径："+filePath);
		file.transferTo(new File(filePath + newFileName)); //将要上传的文件写入到（即上传）服务器上指定文件夹
		ResponseInfo info=new ResponseInfo();   //调用已经声明的文件返回消息的实体类
		info.setData("upload/" + newFileName);  //设置最后路径文件名
		info.setMessage("上传成功");              //设置提示信息
		return info;
	}
	//添加与修改
	@RequestMapping("input")
	public String input(){
		return "user/input";
	}
	
	
	
	
}
