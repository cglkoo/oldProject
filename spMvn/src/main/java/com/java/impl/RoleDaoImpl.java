package com.java.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.java.dao.RoleDao;
import com.java.entity.Page;
import com.java.entity.Role;

@Repository("tblRoleDao")
public class RoleDaoImpl implements RoleDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addRole(Role role) {
		String sql="INSERT INTO t_roles (rName) VALUES (?)";
		int result=jdbcTemplate.update(sql, role.getrName());
		return result;
	}
	@Override
	public int updateRole(Role role) {
		String sql="update t_roles set rName=?  where rId=? ";
		int result=jdbcTemplate.update(sql,role.getrName(),role.getrId());
		return result;
	}
	@Override
	public int deleteRole(int id) {
		String sql="delete from t_roles where rId=?";
		int result=jdbcTemplate.update(sql,id);
		return result;
	}
	@Override  //查询所有角色，原始做法
	public List<Role> getList() {
		String sql="SELECT rId,rName FROM t_roles ";
		List<Role> roleList=new ArrayList<Role>();
		roleList=jdbcTemplate.execute(sql,new PreparedStatementCallback<List<Role>>() {
			@Override
			public List<Role> doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException {
				ResultSet rs = ps.executeQuery(sql);
				List<Role> uList = new ArrayList<>();
				Role u = null;
				while(rs.next()){
					u = new Role();
					u.setrId(rs.getInt("rId"));
					u.setrName(rs.getString("rName"));
					uList.add(u);
				}
				return uList;
			}});
		return roleList;
	}
	@Override  //不带条件的查询所有角色
	public List<Map<String, Object>> getRoleLists() {
		String sql="select rId,rName from t_roles ";
		List<Map<String,Object>> roleList=jdbcTemplate.queryForList(sql);
		return roleList;
	}
	@Override //分页的关键字查询所有角色
	public List<Map<String, Object>> getRoleList(String keyword,Page page) {
		String sql="select rId,rName from t_roles where rName like ? order by rId desc limit ?,?";
		List<Map<String,Object>> rolelist=jdbcTemplate.queryForList(sql,"%"+keyword+"%",page.getPosition(),page.getPageSize());
		return rolelist;
	}
	@Override //不分页的关键字查询所有角色
	public long getRoleLines(String keyword) {
		String sql="select count(1) c from t_roles where rName like ? ";
	    Map<String,Object> map=jdbcTemplate.queryForMap(sql,"%"+keyword+"%");
	    long count=(long) map.get("c");
		return count;
	}
	
	@Override
	public long getRolebyCheckName(String keyword) {
		String sql="select count(1) c from t_roles where rName= ? ";
	    Map<String,Object> map=jdbcTemplate.queryForMap(sql,"%"+keyword+"%");
	    long count=(long) map.get("c");
		return count;
	}
	
	
	

}
