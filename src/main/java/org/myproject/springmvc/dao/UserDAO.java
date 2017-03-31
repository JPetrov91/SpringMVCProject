package org.myproject.springmvc.dao;

import org.myproject.springmvc.model.User;

public interface UserDAO {
	
	User findByUsername(String username);
	int save(User user);

}
