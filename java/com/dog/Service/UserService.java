package com.dog.Service;

import java.util.Map;

import com.dog.entities.User;

public interface UserService {
	void save(User user);
	User getUser(String email);
	Map<String,Object> getUser(String email , String password);
}
