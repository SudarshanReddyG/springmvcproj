package com.sudarshan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.dao.UserDao;
import com.sudarshan.model.AppUser;
import com.sudarshan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public AppUser findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<AppUser> findAll() {
		return userDao.findAll();
	}

	@Override
	public void saveOrUpdate(AppUser user) {
		if(findById(user.getId())==null) { 
			userDao.save(user);		
		} else {
			userDao.update(user);	
		}
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}
