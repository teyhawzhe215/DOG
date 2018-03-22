package com.dog.ServiceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dog.Service.UserService;
import com.dog.dao.UserDao;
import com.dog.entities.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Transactional
	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return userDao.getUser(email);
	}

	@Override
	public Map<String,Object> getUser(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.getUser(email, password);
	}

}
