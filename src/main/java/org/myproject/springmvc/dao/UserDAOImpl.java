package org.myproject.springmvc.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@EnableTransactionManagement
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User findByUsername(String username) {
		Session session = sessionFactory.openSession();
		List<User> users = new ArrayList<>();
		Query query = session.createQuery("from User where username = :username");
		query.setParameter("username", username);
		users = query.list();
		return users.get(0);
	}
	
	@Transactional
	public int save(User user) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(user);
		Serializable id = session.getIdentifier(user);
		session.flush();
		session.close();
		return (Integer) id;
	}

	


}
