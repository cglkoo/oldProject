package com.hzitxx.spring.demo.controller;

import java.util.List;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Hobby;
import com.hzitxx.spring.demo.model.Page;
import com.hzitxx.spring.demo.model.PageSupport;
import com.hzitxx.spring.demo.model.Role;
import com.hzitxx.spring.demo.model.TBlUser;
import com.hzitxx.spring.demo.model.UserHobby;
import com.hzitxx.spring.demo.model.UserRole;
import com.hzitxx.spring.demo.service.HobbyService;
import com.hzitxx.spring.demo.service.IUserHobbyService;
import com.hzitxx.spring.demo.service.IUserRoleService;
import com.hzitxx.spring.demo.service.RoleService;
import com.hzitxx.spring.demo.service.TBlUserService;
import com.hzitxx.spring.demo.vo.ResponseInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger logger = LogManager.getRootLogger();
	
	@Autowired
	private TBlUserService tblUserService;
	
	@Autowired
	private HobbyService hobbyService;

	@Autowired
	private IUserRoleService iUserRoleService;
	
	@Autowired
	private IUserHobbyService iUserHobbyService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("index")
	public String index(Model model,String userName,Page page,Integer pageSize,
			String pageIndex,Long count){
		userName=(userName==null?"":userName);   //默认查询所有
		pageIndex=(pageIndex==null||pageIndex.equals("")?"1":pageIndex);  //默认是第一页
		pageSize=(pageSize==null||pageSize==0?2:pageSize);  //默认分页size=2;
		count = this.tblUserService.getUserLines(userName);
		page=PageSupport.getPage(count, Integer.parseInt(pageIndex), pageSize);
		List<Map<String,Object>> userList = tblUserService.getUserList(userName,page);
		model.addAttribute("page",page);              //分页专用；
		model.addAttribute("userList", userList);    //带条件的查询；
		model.addAttribute("userName",userName);    //保留查询条件；
		return "user/index";
	}
	
	@RequestMapping("deleteUserById")
	@ResponseBody
	public ResponseInfo deleteUserById(String userId) {
		userId=(userId==null||userId.equals("")?"0":userId);
		int count = this.tblUserService.deleteUserById(Integer.parseInt(userId));
		ResponseInfo info = new ResponseInfo();
		info.setMessage(count>0?"删除成功！":"删除失败！");
		return info;
	}
	
	@RequestMapping("deleteUserByUIds")
	public String deleteUserByUIds(String [] uids) {
		boolean f = false;    //默认是删除失败。
		if(null != uids && uids.length>0){
			for(String uid : uids){
				int Id = Integer.parseInt(uid);
				int count = this.tblUserService.deleteUserById(Id);
				if(count > 0){
					f = true;
				}else{
					f = false;
				}
			}
		} 
		return "redirect:index.action"; 
	}
	
	 
	@RequestMapping("add")    //到新增用户页面；
	public String add(Model model,TBlUser user){
		List<Role> rList = null; //this.roleService.getList();
		List<Hobby> hList = this.hobbyService.getList();
		model.addAttribute("rList", rList);  //加载所有的角色；
		model.addAttribute("hList", hList);	 //加载所有的爱好 ；
		model.addAttribute("user",user);
		return "user/add";
	}
	
	@RequestMapping("addUser")    //处理新增用户；
	public String addUser(TBlUser user,String [] userRole, String [] userHobby){
		
		//增加
		if(user.getuId()==0){
			int n=this.tblUserService.addUser(user);  //新增用户名及密码；
			logger.info(n>0?"新增成功:"+user.toString():"新增失败:"+user.toString());
			TBlUser u = this.tblUserService.getUserByLogin(user);
			int uid = u.getuId();  //获取刚刚插入到数据库中的用户ID；
			 //新增角色；
			if(userRole !=null && userRole.length>0){
				for(String roleId : userRole){
					int rid = Integer.parseInt(roleId);
					//接下来往中间表里的增加,uid,rid;
					UserRole ur = new UserRole();
					ur.setuId(uid);
					ur.setrId(rid);
					int m =  this.iUserRoleService.addUserRole(ur);
					logger.info("新增用户角色："+(m>0?"成功！":"失败!"));
				}
			}
			 //新增爱好；
			if(userHobby !=null && userHobby.length>0){
				for(String hobbyId : userHobby){
					int hid = Integer.parseInt(hobbyId);
					//接下来往中间表里的增加,uid,rid;
					UserHobby uh = new UserHobby();
					uh.setuId(uid);
					uh.sethId(hid);
					int m =  this.iUserHobbyService.addUserHobby(uh);
					logger.info("新增用户爱好："+(m>0?"成功！":"失败!"));
				}
			}
			
		}else{   //修改；
			int n = this.tblUserService.updateUser(user);
			logger.info(n>0?"修改成功:"+user.toString():"修改失败:"+user.toString());
			UserRole ur = new UserRole();
			ur.setuId(user.getuId());
			int m = this.iUserRoleService.delUserRole(ur);
			logger.info(m>0?"删除用户的角色成功:"+user.toString():"删除用户的角色失败:"+user.toString());
			UserHobby uh = new UserHobby();
			uh.setuId(user.getuId());
			m = this.iUserHobbyService.delUserHobby(uh);
			logger.info(m>0?"删除用户的爱好成功:"+user.toString():"删除用户的爱好失败:"+user.toString());
			
			//新增修改后的角色；
			if(userRole !=null && userRole.length>0){
				for(String roleId : userRole){
					int rid = Integer.parseInt(roleId);
					//接下来往中间表里的增加,uid,rid;
					UserRole userR = new UserRole();
					userR.setuId(user.getuId());
					userR.setrId(rid);
					m =  this.iUserRoleService.addUserRole(userR);
					logger.info("新增用户修改后的角色："+(m>0?"成功！":"失败!"));
				}
			}
			 //新增修改后的爱好；
			if(userHobby !=null && userHobby.length>0){
				for(String hobbyId : userHobby){
					int hid = Integer.parseInt(hobbyId);
					//接下来往中间表里的增加,uid,hid;
					UserHobby userH = new UserHobby();
					userH.setuId(user.getuId());
					userH.sethId(hid);
					m =  this.iUserHobbyService.addUserHobby(userH);
					logger.info("新增用户修改后的爱好："+(m>0?"成功！":"失败!"));
				}
			}
			
		}
		//记住：相当于Struts2中的redirectAction；相当于JSP中的reponse.sendRedirect();
		return "redirect:index.action";
	}
	
	//查询一个用户信息；
	@RequestMapping("getUser")    //先查询，换修改；
	public String getUser(Model model,String userId){
		userId=(userId==null?"0":userId);
		int uId = Integer.parseInt(userId);				
		Map<String,Object> map=this.tblUserService.getUser(uId);
		model.addAttribute("user",map);
		
		List<Role> rList = null; //this.roleService.getList();
		List<Hobby> hList = this.hobbyService.getList();
		model.addAttribute("rList", rList);
		model.addAttribute("hList", hList);
		
		//查询该用户相对应的角色；
		List<Role> userRoleList = null; //this.roleService.getRoleListByUId(uId);
		model.addAttribute("userRoleList", userRoleList);
		//查询该用户相对应的爱好：
		List<Hobby> userHobbyList = this.hobbyService.getRoleListByUId(uId);
		model.addAttribute("userHobbyList", userHobbyList);
		return "user/add";
	}
	
}
