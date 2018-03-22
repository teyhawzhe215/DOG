package com.dog.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.dog.entities.User;

public interface UserDao {
	@Transactional
	void save(User user);
	@Transactional
	User getUser(String email);
	@Transactional
	Map<String,Object> getUser(String email,String password);
}
