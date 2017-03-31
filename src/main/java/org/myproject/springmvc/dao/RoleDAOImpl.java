package org.myproject.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.springmvc.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@Repository
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public Role getById(Long id) {
		Session session = sessionFactory.openSession();
		Role role = (Role) session.get(Role.class, id);
		session.close();
		return role;
	}

}
