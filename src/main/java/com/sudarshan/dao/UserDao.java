package com.sudarshan.dao;

import java.util.List;

import com.sudarshan.model.AppUser;

public interface UserDao {
	
	AppUser findById(Integer id);
	
	List<AppUser> findAll();
	
	void save(AppUser appuser);
	
	void update(AppUser appuser);
	
	void delete(AppUser appuser);
	
}
