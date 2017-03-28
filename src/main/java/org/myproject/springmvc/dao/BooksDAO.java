package org.myproject.springmvc.dao;

import java.util.List;

import org.myproject.springmvc.model.Book;

public interface BooksDAO {
	
	int add(Book book);
	
	int update(Book book);
	
	int delete(int id);
	
	Book get(int id);
	
	List<Book> list();
}
