package org.myproject.springmvc.dao;

import java.util.List;

import org.myproject.springmvc.model.Genre;

public interface GenresDAO {
	
	List<Genre> findAll();

}
