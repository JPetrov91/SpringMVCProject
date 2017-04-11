package org.myproject.springmvc.service;

import java.util.List;

import org.myproject.springmvc.dao.RoleDAO;
import org.myproject.springmvc.dao.UserDAO;
import org.myproject.springmvc.model.Group;
import org.myproject.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	RoleDAO rolesDAO;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
		Group group = new Group();
		group = userDAO.loadGroupById(1);
		String password = user.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		user.setPassword(encodedPassword);
		user.setGroup(group);
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

	@Override
	public List<User> list() {
		return userDAO.list();
	}

}
