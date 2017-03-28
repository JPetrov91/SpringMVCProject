package org.myproject.springmvc.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.springmvc.model.Idea;
import org.myproject.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
public class IdeasDAOImpl implements IdeasDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public int add(Idea idea) {
		Session session = sessionFactory.openSession();
		Serializable id = session.save(idea);
		session.close();
		return (Integer) id;
	}

	@Transactional
	@Override
	public int update(Idea idea) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(idea);
		Serializable id = session.getIdentifier(idea);
		session.flush();
		session.close();
		return (Integer) id;
	}

	@Transactional
	@Override
	public int delete(int id) {
		Session session = sessionFactory.openSession();
		Idea idea = (Idea) session.get(Idea.class, id);
		session.delete(idea);
		Serializable identifier = session.getIdentifier(idea);
		session.flush();
		session.close();
		return (Integer) identifier;
	}

	@Transactional
	@Override
	public Idea get(int id) {
		Session session = sessionFactory.openSession();
		Idea idea = (Idea) session.get(Idea.class, id);
		session.close();
		return idea;
	}

    @Override
    public List<Idea> list() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Idea> list = session.createQuery("from Idea").list();
        session.close();
        return list;
    }

	@Transactional
    @Override
	public boolean registerUser(User user) {
		Session session = sessionFactory.openSession();
		Serializable id = session.save(user);
		return true;
	}

	@Override
	public boolean isUserExists(String login) {
		Session session = sessionFactory.openSession();
		Long count = (Long) session.getNamedQuery(User.SELECT_USER_COUNT_BY_LOGIN)
				.setParameter("login", login)
				.uniqueResult();
		return count > 0;
	}
	

}
