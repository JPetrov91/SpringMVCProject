package org.myproject.springmvc.dao;

import java.util.List;

import org.myproject.springmvc.model.Group;
import org.myproject.springmvc.model.User;

public interface UserDAO {
	
	User findByUsername(String username);
	
	Long save(User user);
	
	int update(User user);
	
	User getById(long id);
	
	List<User> list();
	
	Group loadGroupById(long id);

}
