package com.sudarshan.service;

import java.util.List;

import com.sudarshan.model.AppUser;

public interface UserService {
	
	AppUser findById(Integer id);
	 
	List<AppUser> findAll();
 
	void saveOrUpdate(AppUser user);
 
	void delete(int id);

}
