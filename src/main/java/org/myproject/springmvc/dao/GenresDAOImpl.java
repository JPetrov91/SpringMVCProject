package org.myproject.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.springmvc.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Repository
public class GenresDAOImpl implements GenresDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Genre> findAll() {
		Session session = sessionFactory.openSession();
		List<Genre> genresList = new ArrayList<>();
		genresList = session.createQuery("from Genre").list();
		session.close();
		return genresList;
	}
	
	
}
