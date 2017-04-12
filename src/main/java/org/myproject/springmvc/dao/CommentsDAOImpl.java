package org.myproject.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myproject.springmvc.model.Comment;
import org.myproject.springmvc.model.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CommentsDAOImpl implements CommentsDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public void add(Comment comment) {
		Session session = sessionFactory.openSession();
		session.save(comment);
		session.close();
	}

	@Transactional
	@Override
	public void delete(int id) {
		Session session = sessionFactory.openSession();
		Comment comment = (Comment) session.get(Comment.class, id);
		session.delete(comment);
		session.flush();
		session.close();
	}

	@Override
	public Comment get(int id) {
		Session session = sessionFactory.openSession();
		Comment comment = (Comment) session.get(Comment.class, id);
		session.close();
		return comment;
	}

	@Override
	public List<Comment> list() {
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<Comment> list = session.createQuery("from Comment").list();
        session.close();
        return list;
	}

}
