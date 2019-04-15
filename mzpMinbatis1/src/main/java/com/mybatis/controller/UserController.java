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
import com.mybatis.entity.Role;
import com.mybatis.entity.User;
import com.mybatis.entity.Page;
import com.mybatis.entity.PageSupport;
import com.mybatis.entity.UserHobby;
import com.mybatis.entity.UserRole;
import com.mybatis.service.IHobbyService;
import com.mybatis.service.IRoleService;
import com.mybatis.service.IUserHobbyService;
import com.mybatis.service.IUserRoleService;
import com.mybatis.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IHobbyService hobbyService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IUserRoleService iUserRoleService;
	@Autowired
	private IUserHobbyService iUserHobbyService;
	
	@RequestMapping("list")
	public String list(Model model,String keyword,Integer pageSize,String pageIndex,String flag){
	    flag=(flag==null?"":flag);
		/*if("sch".equals(flag)){
			keyword=(keyword==null?"":keyword);
		}else{
			keyword="";
		}*/
		keyword=(keyword==null?"":keyword);
		long count=userService.getUserLines("%"+keyword+"%");
		//默认首页时当前页变量的值为1
		long pageNo=Long.parseLong((pageIndex==null||pageIndex.equals(""))?"1":pageIndex);
		pageSize=(pageSize==null||pageSize==0?2:pageSize);
		Page page = PageSupport.getPage(count,pageNo,pageSize);
		
		User user = new User();
		user.setuName("%"+keyword+"%");
		user.setPageIndex((int)pageNo);
		user.setSize(pageSize);
		List<User> userList =this.userService.getUserList(user);

		model.addAttribute("userList",userList);
		model.addAttribute("page",page);
		model.addAttribute("keyword",keyword);
		return "user/list";
	}
	
	//单个删除
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> delete(int userId){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		int result=userService.delUser(userId);
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
			result=userService.delUser(ids[i]);
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

	@RequestMapping("update/{uId}")
	public String getUserById(@PathVariable int uId,Model model){
		User user=new User();
		List<UserRole> userRoleList=null;
		List<UserHobby> userHobbyList=null;
		if(uId>0){
		   user=userService.getUserById(uId);
		   userRoleList=this.iUserRoleService.getRoleListByUId(uId);
		   userHobbyList=this.iUserHobbyService.getHobbyListByUId(uId);
		}
		List<Role> rList=roleService.getRoles();
		List<Hobby> hList=hobbyService.getHobbys();
		model.addAttribute("rList",rList);
		model.addAttribute("hList",hList);
		model.addAttribute("userRoleList",userRoleList);
		model.addAttribute("userHobbyList",userHobbyList);
		model.addAttribute("user",user);
		return "user/input";
	}
	
	@RequestMapping("add")
	public String addUser(User user,String userRole[],String userHobby[]){
		//修改
		if(user.getuId()>0){
			int update = this.userService.updateUser(user);
			System.out.println(update>0?"修改成功":"修改失败");
			List<UserRole> rlist = this.iUserRoleService.getRoleListByUId(user.getuId());
			for(UserRole ur : rlist){
			   this.iUserRoleService.delUserRole(ur);
			}
			//第3步：删除该用户对应的所有爱好ID；（先查出；）
			List<UserHobby> hlist = this.iUserHobbyService.getHobbyListByUId(user.getuId());
			for(UserHobby uh: hlist){
				this.iUserHobbyService.delUserHobby(uh);
			}
			//第4步：插入该用户新对应的所有角色ID；
			
			//新增修改后的角色；
			if(userRole !=null && userRole.length>0){
				for(String roleId : userRole){
					int rid = Integer.parseInt(roleId);
					UserRole userR = new UserRole();
					userR.setuId(user.getuId());
					userR.setrId(rid);
					this.iUserRoleService.addUserRole(userR);   //接下来往中间表里的增加,uid,rid;
					//System.out.println(m>0?"添加成功":"添加失败");
				}
			}
			//第5步：插入该用户新对应的所有爱好ID;
			 //新增修改后的爱好；
			if(userHobby !=null && userHobby.length>0){
				for(String hobbyId : userHobby){
					int hid = Integer.parseInt(hobbyId);
					UserHobby userH = new UserHobby();
					userH.setuId(user.getuId());
					userH.sethId(hid);
					this.iUserHobbyService.addUserHobby(userH);//接下来往中间表里的增加,uid,hid;
				}
			}
			
		}else{ 
			
			this.userService.addUser(user);
			//System.out.println(n>0?"添加成功":"添加失败");
			int uid = user.getuId();    //获取刚刚插入到数据库中的用户ID；Hibernate特有的功能；
			 //根据用户的ID对中间表增添加；
			if(userRole !=null && userRole.length>0){
				for(String roleId : userRole){
					int rid = Integer.parseInt(roleId);
					UserRole ur = new UserRole();
					ur.setuId(uid);
					ur.setrId(rid);
					this.iUserRoleService.addUserRole(ur);  //接下来往中间表里的增加,uid,rid;
				}
			}
			if(userHobby !=null && userHobby.length>0){
				for(String hobbyId : userHobby){
					int hid = Integer.parseInt(hobbyId);
					UserHobby uh = new UserHobby();
					uh.setuId(uid);
					uh.sethId(hid);
			       this.iUserHobbyService.addUserHobby(uh); //接下来往中间表里的增加,uid,hid;
				}
			}
		}
		return "redirect:/user/list";
	}

	
}
