package org.myproject.springmvc.service;

import java.util.List;

import org.myproject.springmvc.dto.BooksDTO;

public interface BooksService {
	
	int add(BooksDTO booksDTO);
	
	int update(BooksDTO booksDTO);
	
	int delete(int id);
	
	BooksDTO get(int id);
	
	List<BooksDTO> list();
}
