package org.myproject.springmvc.dao;

import org.myproject.springmvc.model.User;

public interface UserDAO {
	
	User findByUsername(String username);
	Long save(User user);
	int update(User user);
	User getById(long id);

}
