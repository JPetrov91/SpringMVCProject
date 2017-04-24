package org.myproject.springmvc.service;

import java.util.List;

import org.myproject.springmvc.dao.GenresDAO;
import org.myproject.springmvc.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("genresService")
public class GenresServiceImpl implements GenresService {
	
	@Autowired
	GenresDAO genresDAO;
	
	@Override
	public List<Genre> findAll() {
		return genresDAO.findAll();
	}
}
