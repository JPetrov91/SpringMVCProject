package org.myproject.springmvc.service;

import java.util.List;

import org.myproject.springmvc.model.User;

public interface UserService {
	
	void save(User user);
	
	User findByUsername(String username);
	
	User getById(long id);
	
	void update(User editedUser);
	
	List<User> list();

}
