package com.hzitxx.spring.demo.service;

import java.util.List;
import java.util.Map;

import com.entity.TBlUser;
import com.hzitxx.spring.demo.model.Page;

public interface TBlUserService2 {
	
	public int addTBlUser(TBlUser user);
	public int deleteTBlUser(int id);
	public Long getTBlUserLines(String keyword);
	public List<TBlUser> getTBlUserList(String keyword,Page page,String orderBy);
	public TBlUser getTBlUserbyCheckName(String userName);
	public TBlUser getTBlUserbyId(int id);
	public int updateTBlUser(TBlUser user);
	

}
