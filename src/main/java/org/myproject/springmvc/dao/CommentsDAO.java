package org.myproject.springmvc.dao;

import java.util.List;

import org.myproject.springmvc.model.Comment;

public interface CommentsDAO {
	
	void add(Comment comment);
	
	void delete(int id);
	
	Comment get(int id);
	
	List<Comment> list();
}
