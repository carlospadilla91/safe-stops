package com.safeStops.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.safeStops.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static {
		users = populateDummyUsers();
	}
	
	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user: users) {
			if(user.getId() == id) return user;
		}
		return null;
	}
	
	public User findByUsername(String username) {
		for(User user : users) {
			if(user.getUsername().equalsIgnoreCase(username)) return user;
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public boolean isUserExist(User user) {
		return findByUsername(user.getUsername()) != null;
	}
	
	private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"admin", "admin@email.com", "topsecurity"));
        users.add(new User(counter.incrementAndGet(),"sammy789", "sammy@email.com", "password1234"));
        users.add(new User(counter.incrementAndGet(),"tonyparker", "tony@email.com", "spurs2014"));
        return users;
    }

}
