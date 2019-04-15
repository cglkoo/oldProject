package com.user.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String userName;
	private String userPwd;
	private String json;
	private TBlUser user;

	IUserService ius = new UserServiceImpl();
	HttpServletRequest request = ServletActionContext.getRequest();
	Map<String,Object> session = ActionContext.getContext().getSession();
	
	//注册
	public String reg(){
		String sql="INSERT INTO tbl_user (userName,userPwd) VALUES(?,?) ";
		int num=ius.addOrUpdateOrDelete(sql,userName,userPwd);
		if(num>0){
			request.setAttribute("info", "注册成功");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//登录
	public String login(){
		String sql = "select * from tbl_user where userName=? and userPwd=? ";
		List<TBlUser> list = ius.getUsersByProperty(sql, userName, userPwd);
		if (list.size() > 0 && list!=null) {
			user = list.get(0);
			session.put("user", user);
			session.put("msg", "登录成功");
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//用户名唯一性验证
	public String checkUserName(){
		String sql = "select * from tbl_user where userName = ?";
		List<TBlUser> list = ius.getUsersByProperty(sql, userName);
		JSONObject obj = new JSONObject();
		if(null != list && list.size() > 0){
			obj.put("data", 1);
		}else{
			obj.put("data", 0);
		}
		json=obj.toJSONString();
		return SUCCESS;
	}
	
	//查询所有用户的信息！   //查询数据库的用户信息
	public String search(){
		List<TBlUser> list = ius.getUsersByProperty("select * from tbl_user");
		request.setAttribute("list", list);
		return SUCCESS;
	}

	//根据用户ID删除用户：然后再查询出来，显示在原来的页面上！
	public String deleteUser(){
		String uid = request.getParameter("userId");
		if(uid!=null && uid.trim().length()>0){
			int id=Integer.parseInt(uid);
			int num = ius.addOrUpdateOrDelete("delete from tbl_user where uId=?", id);
			if(num>0){
				session.put("msg", "删除成功");
			    return SUCCESS;
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
	}
	
	//根据用户ID查询用户：然后再显示在页面上，便于修改！
	public String updateUser(){
		String uid = request.getParameter("userId");
		if(uid!=null && uid.trim().length()>0){
			int id=Integer.parseInt(uid);
			List<TBlUser> list = ius.getUsersByProperty("select * from tbl_user where uId=?",id);
			TBlUser user= null;
			if(list!=null && list.size()>0){
				user = list.get(0);
			    request.setAttribute("user", user);
			}
			return SUCCESS;
		}else{
			
			return ERROR;
		}
	}
	
	//处理修改用户结果的方法！
	public String updateUserResult(){
		String sql="update tbl_user set userName=?,userPwd=? where uId=?";
		int num=ius.addOrUpdateOrDelete(sql, userName,userPwd,userId);
		if(num>0){ 
			session.put("msg", "修改成功");
			return SUCCESS;
		}else{
			return ERROR;
		}	
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}

	public TBlUser getUser() {
		return user;
	}

	public void setUser(TBlUser user) {
		this.user = user;
	}
	
}
