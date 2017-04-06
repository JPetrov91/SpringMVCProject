package org.myproject.springmvc.service;

import java.util.HashSet;
import java.util.Set;

import org.myproject.springmvc.dao.RoleDAO;
import org.myproject.springmvc.dao.UserDAO;
import org.myproject.springmvc.model.Role;
import org.myproject.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	RoleDAO rolesDAO;

	@Override
	public void save(User user) {
		Set<Role> roles = new HashSet<>();
		roles.add(rolesDAO.getById(1L));
		user.setRoles(roles);
		userDAO.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	public User getById(long id) {
		return userDAO.getById(id);
	}

	@Override
	public void update(User editedUser) {
		userDAO.update(editedUser);
	}

}
