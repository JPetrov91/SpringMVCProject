package org.myproject.springmvc.service;

import java.util.List;

import org.myproject.springmvc.model.Comment;

public interface CommentsService {
	
	void add(Comment comment, int bookId, int userId);
	
	void delete(int id);
	
	Comment get(int id);
	
	List<Comment> list();
	
	List<Comment> listByBook(int bookId);

}
