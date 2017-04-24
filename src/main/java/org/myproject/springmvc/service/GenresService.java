package org.myproject.springmvc.service;

import java.util.List;

import org.myproject.springmvc.model.Genre;

public interface GenresService {
	
	List<Genre> findAll();
}
