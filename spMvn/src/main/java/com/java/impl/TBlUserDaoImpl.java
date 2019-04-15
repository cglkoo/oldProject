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

import com.java.dao.TBlUserDao;
import com.java.entity.Page;
import com.java.entity.TBlUser;

@Repository("tblUserDao")
public class TBlUserDaoImpl implements TBlUserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addUser(TBlUser user) {
		String sql="INSERT INTO t_users (userName,userPwd,userIcon) VALUES(?,?,?)";
		int result=jdbcTemplate.update(sql, user.getUserName(),user.getUserPwd(),user.getUserIcon());
		return result;
	}
	@Override
	public int updateUser(TBlUser user) {
		String sql="update t_users set userName=? userPwd=? userIcon=? where uId=? ";
		int result=jdbcTemplate.update(sql,user.getUserName(),user.getUserPwd(),user.getUserIcon(),user.getuId());
		return result;
	}

	@Override
	public int deleteUser(int id) {
		String sql="delete from t_users where uId=?";
		int result=jdbcTemplate.update(sql,id);
		return result;
	}
	@Override  //查询所有用户，原始做法
	public List<TBlUser> getList() {
		String sql="SELECT * FROM t_users ";
		List<TBlUser> userList=new ArrayList<TBlUser>();
		userList=jdbcTemplate.execute(sql,new PreparedStatementCallback<List<TBlUser>>() {
			@Override
			public List<TBlUser> doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException {
				ResultSet rs = ps.executeQuery(sql);
				List<TBlUser> uList = new ArrayList<>();
				TBlUser u = null;
				while(rs.next()){
					u = new TBlUser();
					u.setuId(rs.getString("uId"));
					u.setUserName(rs.getString("userName"));
					u.setUserPwd(rs.getString("userPwd"));
					u.setUserIcon(rs.getString("userIcon"));
					uList.add(u);
				}
				return uList;
			}});
		return userList;
	}
	@Override  //不带条件的查询所有用户
	public List<Map<String, Object>> getUserLists() {
		String sql="select * from t_users ";
		List<Map<String,Object>> userList=jdbcTemplate.queryForList(sql);
		return userList;
	}
	@Override //分页的关键字查询所有用户
	public List<Map<String, Object>> getUserList(String keyword,Page page) {
		String sql="select * from t_users where userName like ? order by uId desc limit ?,?";
		List<Map<String,Object>> uesrlist=jdbcTemplate.queryForList(sql,"%"+keyword+"%",page.getPosition(),page.getPageSize());
		return uesrlist;
	}
	@Override //不分页的关键字查询所有用户
	public long getUserLines(String keyword) {
		String sql="select count(1) c from t_users where userName like ? ";
	    Map<String,Object> map=jdbcTemplate.queryForMap(sql,"%"+keyword+"%");
	    long count=(long) map.get("c");
		return count;
	}
	@Override
	public long getUserbyCheckName(String keyword) {
		String sql="select count(1) c from t_users where userName = ? ";
		Map<String,Object> map=jdbcTemplate.queryForMap(sql,"%"+keyword+"%");
	    long count=(long) map.get("c");
		return count;
	}
	
	
	
	

}
