package com.dog.Service;

import java.util.List;
import java.util.Map;

import com.dog.entities.User;

public interface UserService {
	void save(User user);
	User getUser(String email);
	List<Map<String,Object>> getUser(String email , String password);
}
