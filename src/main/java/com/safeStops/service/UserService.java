package com.safeStops.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.safeStops.model.User;

@Service
public interface UserService {
	
	User findById(long id);
	
	User findByUsername(String username);
	
	void saveUser(User user);
	
	List<User> findAllUsers();
	
	public boolean isUserExist(User user);

}
