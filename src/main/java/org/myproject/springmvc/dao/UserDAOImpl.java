package org.myproject.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public User findByUsername(String username) {
		List<User> users = new ArrayList<User>();
		Session session = sessionFactory.openSession();
		users = session.createQuery("from User where username=?").list();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	


}
