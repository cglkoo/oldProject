package com.role.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private String roleName;
	private String msg;
	List<Role> list= new ArrayList<>();
	
	IRoleService irc= new RoleServiceImpl();
	
	//查询所有的方法,即更新的方法
	public String list(){
		list=irc.getRoleByProperty("select rId,rName from t_roles");
		return SUCCESS;
	}
	
	//添加页面,转向到修改页面添加
	public String add(){
		return "add";
	}
	
	//修改页面，兼添加功能
	public String update(){
		int num=0;
		if(roleId>0){
			num=irc.addOrUpdateOrDelete("update t_roles set rName=? where rId=?", roleName,roleId);
			if(num>0){
				msg="修改成功";
			}else{
				msg="修改失败";
			}
		}else{
			num=irc.addOrUpdateOrDelete("insert into t_roles (rName) values(?) ", roleName);
			if(num>0){
				msg="添加成功";
			}else{
				msg="添加失败";
			}
		}
		list=irc.getRoleByProperty("select rId,rName from t_roles");
		return SUCCESS;
	}

	//删除方法
	public String delete(){
		int num = irc.addOrUpdateOrDelete("delete from t_roles where rId=?", roleId);
		if(num>0){
			msg="删除成功";
		}else{
			msg="删除失败";
		}
		list=irc.getRoleByProperty("select rId,rName from t_roles");
		return SUCCESS;
	}
	//get方法,条件查询
	public String get(){
		list = irc.getRoleByProperty("select rId,rName from t_roles where rId=?", roleId);
		if(list!=null && list.size()>0){
			Role r= list.get(0);
			this.roleId=r.getrId();
			this.roleName=r.getrName();
		}
		return "add";
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Role> getList() {
		return list;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}

	public IRoleService getIrc() {
		return irc;
	}

	public void setIrc(IRoleService irc) {
		this.irc = irc;
	}
	
}
