package org.myproject.springmvc.dao;

import java.util.List;

import org.myproject.springmvc.model.Idea;
import org.myproject.springmvc.model.User;

public interface IdeasDAO {
	
	int add(Idea idea);
	
	int update(Idea idea);
	
	int delete(int id);
	
	Idea get(int id);
	
	List<Idea> list();

	boolean registerUser(User user);

	boolean isUserExists(String login);
}
