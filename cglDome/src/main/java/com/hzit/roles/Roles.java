package com.hzit.roles;

public class Roles {
	private int roleId;
	private String roleName;
	public Roles(){
		
	}
	public Roles(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
}
